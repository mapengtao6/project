package com.bw.myproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.adapter.CircleAdapter;
import com.bw.myproject.bean.CircleBean;
import com.bw.myproject.presenter.CirclePresenter;
import com.bw.myproject.view.CircleView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Time:2019.03.20--14:33
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CircleFragment extends Fragment implements CircleView {

    @BindView(R.id.circle_rlv)
    RecyclerView rlv;
    Unbinder unbinder;
    private CirclePresenter presenter;
    private int page = 1;
    private int count = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.circle_fragment, null, false);
        unbinder = ButterKnife.bind(this, view);

        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter = new CirclePresenter(this);

        presenter.circle(page, count);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getCiecle(CircleBean circleBean) {

        List<CircleBean.ResultBean> result = circleBean.getResult();

//        Toast.makeText(getActivity(), ""+result.toString(), Toast.LENGTH_SHORT).show();

        CircleAdapter circleAdapter = new CircleAdapter(getActivity(), result);

        rlv.setAdapter(circleAdapter);
    }
}
