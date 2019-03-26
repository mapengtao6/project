package com.bw.myproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;
import com.bw.myproject.R;
import com.bw.myproject.adapter.HomeSelectAdapter;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.presenter.HomeSelPresenter;
import com.bw.myproject.view.HomeSelView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeSelectActivity extends AppCompatActivity implements HomeSelView {

    @BindView(R.id.homeselect_rlv)
    RecyclerView rlv;

    public String keyword;
    public int page = 1;
    public int count = 10;
    @BindView(R.id.homesel_srl)
    SwipyRefreshLayout srl;
    private HomeSelPresenter presenter;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_select);
        ButterKnife.bind(this);

        rlv.setLayoutManager(new GridLayoutManager(this, 2));

        Intent intent = getIntent();

        keyword = intent.getStringExtra("keyword");


        presenter = new HomeSelPresenter(this);

        presenter.addachView(this);


        if (keyword == keyword) {
            presenter.search(this.keyword, page, count);
        } else {

            Toast.makeText(this, "关键字不存在~", Toast.LENGTH_SHORT).show();
        }

//        刷新
        getrefresh();

    }

    private void getrefresh() {

        srl.setColorSchemeResources(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.cardview_shadow_start_color);
//        模式
        srl.setDirection(SwipyRefreshLayoutDirection.BOTH);
//        设置监听
        srl.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(int index) {

                page = 1;
                presenter.search(keyword, page, count);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(HomeSelectActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                        srl.setRefreshing(false);

                    }
                }, 2000);

            }

            @Override
            public void onLoad(int index) {

                page++;
                presenter.search(keyword, page, count);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        srl.setRefreshing(false);
                        Toast.makeText(HomeSelectActivity.this, "加载成功~", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void getDataViews(SearchBean searchBean) {

        List<SearchBean.ResultBean> result = searchBean.getResult();

//        Toast.makeText(this, "" + result.toString(), Toast.LENGTH_SHORT).show();

        HomeSelectAdapter homeSelectAdapter = new HomeSelectAdapter(this, result);

        rlv.setAdapter(homeSelectAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }
}
