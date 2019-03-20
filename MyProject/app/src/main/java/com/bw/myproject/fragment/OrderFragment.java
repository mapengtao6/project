package com.bw.myproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.myproject.R;

/**
 * Time:2019.03.20--14:39
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OrderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.order_fragment, null, false);


        return view;
    }
}
