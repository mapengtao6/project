package com.bw.myproject.presenter;

import com.bw.myproject.bean.RegBean;
import com.bw.myproject.model.RegModel;
import com.bw.myproject.view.RegView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * Time:2019.03.23--15:42
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class RegPresenter<T> {

    private Reference<T> tReference;
    private final RegModel regModel;
    private final RegView regView;

    public void addachView(T t) {

        tReference = new WeakReference<T>(t);
    }

    public void deatchView() {

        if (tReference != null) {
            tReference.clear();
            tReference = null;
        }
    }

    public RegPresenter(RegView view) {

        regModel = new RegModel();

        regView = view;
    }

    public void reg(Map<String, String> param) {
        regModel.reg(param);
        regModel.setReginLisenter(new RegModel.onReginLisenter() {
            @Override
            public void onReg(RegBean regBean) {
                regView.getViewData(regBean);
            }
        });

    }
}
