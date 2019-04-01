package com.bw.myproject.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.bw.myproject.R;
import com.bw.myproject.adapter.ShopSelAdapter;
import com.bw.myproject.bean.ShopSelBean;
import com.bw.myproject.presenter.ShopSelPresenter;
import com.bw.myproject.view.ShopSelView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:2019.03.20--14:39
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShoppCardFragment extends Fragment implements View.OnClickListener, ShopSelView {

    @BindView(R.id.shop_rlv)
    RecyclerView rlv1;
    Unbinder unbinder;
    @BindView(R.id.shop_checkbox)
    CheckBox checkbox;
    @BindView(R.id.shop_settlement)
    Button settlement;
    private ShopSelPresenter presenter;

    /* private String userId = "304";
     private String sessionId = "1553776255819304";*/
    private View view;
    private String userId;
    private String sessionId;
    private ShopSelAdapter shopSelAdapter;

    /* private String userId;
     private String sessionId;
 */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.shoppcard_fragment, null, false);

        unbinder = ButterKnife.bind(this, view);


        initID();

        return view;
    }

    private void initID() {

        rlv1.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter = new ShopSelPresenter(this);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("button", Context.MODE_PRIVATE);

        userId = sharedPreferences.getString("userId", "");
        sessionId = sharedPreferences.getString("sessionId", "");


        presenter.shopsel(userId, sessionId);


        checkbox.setOnClickListener(this);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getViewData(ShopSelBean shopSelBean) {

        List<ShopSelBean.ResultBean> result = shopSelBean.getResult();

//        Toast.makeText(getActivity(), ""+result.toString(), Toast.LENGTH_SHORT).show();

//        适配器
        shopSelAdapter = new ShopSelAdapter(getActivity(), result, new ShopSelAdapter.onCheckLisenter() {
            @Override
            public void oncheck(boolean isCheck) {
                checkbox.setChecked(isCheck);
            }
        });
        rlv1.setAdapter(shopSelAdapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.shop_checkbox:

                if (((CheckBox) v).isChecked()) {
                    shopSelAdapter.notifCheckData(true);
                } else {
                    shopSelAdapter.notifCheckData(false);
                }

                break;
        }
    }
}
