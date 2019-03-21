package com.bw.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bw.myproject.adapter.HomeSelectAdapter;
import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.presenter.HomePresenter;
import com.bw.myproject.view.HomeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeSelectActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.homeselect_rlv)
    RecyclerView rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_select);
        ButterKnife.bind(this);

        rlv.setLayoutManager(new GridLayoutManager(this, 2));

        HomePresenter presenter = new HomePresenter(this);

    }


    @Override
    public void getDataView(HomeBean homeBean) {

    }

    @Override
    public void getDataViews(SearchBean searchBean) {
        List<SearchBean.ResultBean> result = searchBean.getResult();

//        Toast.makeText(this, ""+result.toString(), Toast.LENGTH_SHORT).show();

        HomeSelectAdapter homeSelectAdapter = new HomeSelectAdapter(this, result);

        rlv.setAdapter(homeSelectAdapter);
    }
}
