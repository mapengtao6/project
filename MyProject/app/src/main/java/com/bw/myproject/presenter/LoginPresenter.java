package com.bw.myproject.presenter;

import com.bw.myproject.bean.LoginBean;
import com.bw.myproject.model.LoginModel;
import com.bw.myproject.view.LoginView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * Time:2019.03.23--17:07
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class LoginPresenter<T> {

    private Reference<T> tReference;
    private final LoginModel loginModel;
    private final LoginView loginView;

    public void addachView(T t) {

        tReference = new WeakReference<T>(t);
    }

    public void deatchView() {

        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }


    public LoginPresenter(LoginView view) {

        loginModel = new LoginModel();

        loginView = view;
    }

    public void login(Map<String, String> param) {

        loginModel.login(param);
        loginModel.setLoginLisenter(new LoginModel.onLoginLisenter() {
            @Override
            public void onLogin(LoginBean loginBean) {
                loginView.getViewData(loginBean);
            }
        });
    }
}
