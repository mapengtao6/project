package com.bw.myproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.adapter.OneOrderAdapter;
import com.bw.myproject.adapter.TwoOrderAdapter;
import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.TwoOrdeBean;
import com.bw.myproject.presenter.OrderPresenter;
import com.bw.myproject.view.OrderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FenleiActivity extends AppCompatActivity implements OrderView {

    @BindView(R.id.oneorder_rlv1)
    RecyclerView rlv1;
    @BindView(R.id.oneorder_rlv2)
    RecyclerView rlv2;
    private OrderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
        ButterKnife.bind(this);

        rlv1.setLayoutManager(new LinearLayoutManager(this));
        rlv2.setLayoutManager(new LinearLayoutManager(this));

        presenter = new OrderPresenter(this);

        presenter.orderone();
    }

    //    一级列表

    @Override
    public void getViewData(OneOrderBean oneOrderBean) {

        final List<OneOrderBean.ResultBean> result = oneOrderBean.getResult();

//        Toast.makeText(this, "" + result.toString(), Toast.LENGTH_SHORT).show();

        OneOrderAdapter oneOrderAdapter = new OneOrderAdapter(this, result);

        rlv1.setAdapter(oneOrderAdapter);

        oneOrderAdapter.setClickLisenter(new OneOrderAdapter.onClickLisenter() {
            @Override
            public void onClick(View view, int position) {

                String firstCategoryId = result.get(position).getId();

                presenter.ordertwo(firstCategoryId);
            }
        });
    }

    //    二级列表
    @Override
    public void getViewDatas(TwoOrdeBean twoOrdeBean) {
        List<TwoOrdeBean.ResultBean> results = twoOrdeBean.getResult();

//        Toast.makeText(this, "" + result.toString(), Toast.LENGTH_SHORT).show();

        TwoOrderAdapter twoOrderAdapter = new TwoOrderAdapter(this, results);

        rlv2.setAdapter(twoOrderAdapter);
    }
}
