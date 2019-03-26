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
import com.bw.myproject.bean.RegBean;
import com.bw.myproject.presenter.RegPresenter;
import com.bw.myproject.utils.Utils;
import com.bw.myproject.view.RegView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends AppCompatActivity implements View.OnClickListener, RegView {

    @BindView(R.id.reg_phone)
    EditText reg_phone;
    @BindView(R.id.reg_pwd)
    EditText reg_pwd;
    @BindView(R.id.me_login)
    TextView login;
    @BindView(R.id.reg_button)
    Button reg_button;
    private RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

        presenter = new RegPresenter(this);

        login.setOnClickListener(this);
        reg_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_login:

                startActivity(new Intent(RegActivity.this, LoginActivity.class));
                break;

            case R.id.reg_button:

//                获取文本框
                String phone = reg_phone.getText().toString();
                String pwd = reg_pwd.getText().toString();
                boolean mobileNO = Utils.isMobileNO(phone);
                if (!mobileNO) {
                    Toast.makeText(this, "手机号格式有误~", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.length() < 3) {
                    Toast.makeText(this, "密码长度不够~", Toast.LENGTH_SHORT).show();
                    return;
                }

//                startActivity(new Intent(RegActivity.this, LoginActivity.class));

                Map<String, String> param = new HashMap<>();
                param.put("phone", phone);
                param.put("pwd", pwd);

                presenter.addachView(this);
                presenter.reg(param);
                break;
        }
    }

    @Override
    public void getViewData(RegBean regBean) {

        String status = regBean.getStatus();
        String message = regBean.getMessage();


        if (status.equals("0000")) {

            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegActivity.this, LoginActivity.class));
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
