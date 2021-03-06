package com.bw.myproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.myproject.R;
import com.bw.myproject.activity.LoginActivity;
import com.bw.myproject.activity.ShopAddressActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:2019.03.20--14:36
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class MineFragment extends Fragment {

    @BindView(R.id.me_head)
    SimpleDraweeView me_image;
    Unbinder unbinder;
    @BindView(R.id.me_title)
    TextView me_title;
    @BindView(R.id.mine_shopaddress)
    TextView shopaddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mine_fragment, null, false);

        unbinder = ButterKnife.bind(this, view);


        me_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

//        收货地址地点击
        shopaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShopAddressActivity.class));
            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("button", Context.MODE_PRIVATE);

        String nickName = sharedPreferences.getString("nickName", "");
        String headPic = sharedPreferences.getString("headPic", "");


        me_title.setText(nickName);

        Uri uri = Uri.parse(headPic);
        me_image.setImageURI(uri);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
