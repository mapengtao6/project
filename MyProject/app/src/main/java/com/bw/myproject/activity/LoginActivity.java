package com.bw.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.bean.LoginBean;
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
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);


        button.setOnClickListener(this);
        reg.setOnClickListener(this);
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


        if (status.equals("0000")) {

            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();


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
