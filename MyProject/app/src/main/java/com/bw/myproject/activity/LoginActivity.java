package com.bw.myproject.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.bean.LoginBean;
import com.bw.myproject.fragment.MineFragment;
import com.bw.myproject.presenter.LoginPresenter;
import com.bw.myproject.utils.Utils;
import com.bw.myproject.view.LoginView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.me_reg)
    TextView reg;
    @BindView(R.id.login_button)
    Button button;
    @BindView(R.id.memory_pwd)
    CheckBox checkbox;
    private LoginPresenter presenter;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);

        button.setOnClickListener(this);
        reg.setOnClickListener(this);

//        记住密码
        sp = getSharedPreferences("button", Context.MODE_PRIVATE);

        boolean remind_pwd = sp.getBoolean("remind_pwd", false);

        edit = sp.edit();

        if (remind_pwd) {
            String phone_sp = sp.getString("phone_sp", "");
            String pwd_sp = sp.getString("pwd_sp", "");
            login_phone.setText(phone_sp);
            login_pwd.setText(pwd_sp);
            checkbox.setChecked(true);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.me_reg:

                startActivity(new Intent(LoginActivity.this, RegActivity.class));

                break;

            case R.id.login_button:

//                获取文本框
                String phone = login_phone.getText().toString();
                String pwd = login_pwd.getText().toString();
                boolean mobileNO = Utils.isMobileNO(phone);

                if (!mobileNO) {
                    Toast.makeText(this, "手机号格式不对~", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.length() < 3) {
                    Toast.makeText(this, "密码长度不够~", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SharedPreferences.Editor edit = sp.edit();
                    if (checkbox.isChecked()) {
                        edit.putBoolean("remind_pwd", true);
                        edit.putString("phone_sp", phone);
                        edit.putString("pwd_sp", pwd);
                    } else {
                        edit.clear();
                    }
                    edit.commit();
                }


                Map<String, String> param = new HashMap<>();
                param.put("phone", phone);
                param.put("pwd", pwd);

                presenter.addachView(this);
                presenter.login(param);
                break;
        }
    }

    @Override
    public void getViewData(LoginBean loginBean) {

        String status = loginBean.getStatus();
        String message = loginBean.getMessage();

        LoginBean.ResultBean result = loginBean.getResult();

        String sessionId = loginBean.getResult().getSessionId();
        String userId = loginBean.getResult().getUserId();
        String headPic = result.getHeadPic();
        String nickName = result.getNickName();


        edit.putString("userId", userId);
        edit.putString("sessionId", sessionId);
        edit.commit();

        if (status.equals("0000")) {

            Log.i("eeee", loginBean.getResult().toString());

            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            edit.putString("headPic", headPic);
            edit.putString("nickName", nickName);
            edit.commit();
            finish();

        } else {
            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }
}
