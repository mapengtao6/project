package com.bw.myproject.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.adapter.ShopAddressAdapter;
import com.bw.myproject.bean.ShopAddressBean;
import com.bw.myproject.presenter.ShopAddressPresenter;
import com.bw.myproject.view.ShopAddressView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopAddressActivity extends AppCompatActivity implements ShopAddressView {

    @BindView(R.id.shopaddress_rlv)
    RecyclerView rlv;
    private ShopAddressPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_address);
        ButterKnife.bind(this);

        SharedPreferences sharedPreferences = getSharedPreferences("button", Context.MODE_PRIVATE);

        String userId = sharedPreferences.getString("userId", "");
        String sessionId = sharedPreferences.getString("sessionId", "");

        rlv.setLayoutManager(new LinearLayoutManager(this));

        presenter = new ShopAddressPresenter(this);


        presenter.shopaddress(userId, sessionId);
    }

    @Override
    public void getShopAddress(ShopAddressBean shopAddressBean) {
        List<ShopAddressBean.ResultBean> result = shopAddressBean.getResult();

        Toast.makeText(this, "" + result.toString(), Toast.LENGTH_SHORT).show();

        ShopAddressAdapter shopAddressAdapter = new ShopAddressAdapter(this, result);
        rlv.setAdapter(shopAddressAdapter);
    }
}
