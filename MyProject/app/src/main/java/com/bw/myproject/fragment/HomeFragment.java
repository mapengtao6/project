package com.bw.myproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.myproject.HomeSelectActivity;
import com.bw.myproject.R;
import com.bw.myproject.adapter.HomeOneAdapter;
import com.bw.myproject.adapter.HomeThreeAdapter;
import com.bw.myproject.adapter.HomeTwoAdapter;
import com.bw.myproject.bean.HomeBean;
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.presenter.HomePresenter;
import com.bw.myproject.view.HomeView;
import com.bw.myproject.weiget.Custom_View;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
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
public class HomeFragment extends Fragment implements HomeView {
    @BindView(R.id.home_rlv1)
    RecyclerView rlv1;
    @BindView(R.id.home_rlv2)
    RecyclerView rlv2;
    @BindView(R.id.home_rlv3)
    RecyclerView rlv3;
    @BindView(R.id.flybanner)
    FlyBanner flybanner;
    private HomePresenter presenter;

    public String keyword = "高跟鞋";
    public int page = 1;
    public int count = 10;
    private Unbinder unbinder;
    private Custom_View custom_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, null, false);
        unbinder = ButterKnife.bind(this,view);

        custom_view = view.findViewById(R.id.custom_view);

//        第一块
        getOne();
//        轮播
        getLun();

        getSerach();

        return view;
    }

    private void getSerach() {


        custom_view.setCustLisenter(new Custom_View.onCustLisenter() {
            @Override
            public void onCust(String keyword) {

                Intent intent = new Intent(getActivity(),HomeSelectActivity.class);
                intent.putExtra("keyword",keyword);

                startActivity(new Intent(intent));
            }
        });

    }

    //    轮播
    private void getLun() {
        List<String> banner = new ArrayList<>();

        banner.add("http://172.17.8.100/images/small/banner/cj.png");
        banner.add("http://172.17.8.100/images/small/banner/hzp.png");
        banner.add("http://172.17.8.100/images/small/banner/lyq.png");
        banner.add("http://172.17.8.100/images/small/banner/px.png");
        banner.add("http://172.17.8.100/images/small/banner/wy.png");

        for (int i = 0; i < banner.size(); i++) {
            banner.get(i);
        }

        flybanner.setImagesUrl(banner);
    }

    private void getOne() {

//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
//        rlv1.setg(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
//        rlv1.setLayoutManager(layoutManager);
//        LinearLayoutManager ms = new LinearLayoutManager(getActivity());
//        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rlv1.setLayoutManager(ms);

//                设置布局
        rlv1.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        rlv2.setLayoutManager(new LinearLayoutManager(getActivity()));

        rlv3.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        presenter = new HomePresenter(this);

        presenter.home();

//        搜索
//        presenter.search(keyword, page, count);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getDataView(HomeBean homeBean) {

        HomeBean.ResultBean result = homeBean.getResult();

        //        -----------------------One--------------------------

        HomeBean.ResultBean.RxxpBean rxxp = result.getRxxp();

        List<HomeBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();

//        Toast.makeText(getActivity(), ""+commodityList.toString(), Toast.LENGTH_SHORT).show();

        HomeOneAdapter homeOneAdapter = new HomeOneAdapter(getActivity(), commodityList);

        rlv1.setAdapter(homeOneAdapter);

        //        -----------------------Two--------------------------

        HomeBean.ResultBean.MlssBean mlss = result.getMlss();
        List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList2 = mlss.getCommodityList();

        HomeTwoAdapter homeTwoAdapter = new HomeTwoAdapter(getActivity(), commodityList2);
        rlv2.setAdapter(homeTwoAdapter);

        //        -----------------------Three--------------------------

        HomeBean.ResultBean.PzshBean pzsh = result.getPzsh();

        List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityList3 = pzsh.getCommodityList();

//        适配器
        HomeThreeAdapter homeThreeAdapter = new HomeThreeAdapter(getActivity(), commodityList3);
        rlv3.setAdapter(homeThreeAdapter);
    }
}
