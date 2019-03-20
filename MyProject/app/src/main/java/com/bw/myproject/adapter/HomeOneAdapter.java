package com.bw.myproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.myproject.R;
import com.bw.myproject.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Time:2019.03.20--19:33
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeOneAdapter extends RecyclerView.Adapter<HomeOneAdapter.MyViewHolder> {

    Context context;
    List<HomeBean.ResultBean.RxxpBean.CommodityListBean> commodityListBean;

    public HomeOneAdapter(Context context, List<HomeBean.ResultBean.RxxpBean.CommodityListBean> commodityListBean) {
        this.context = context;
        this.commodityListBean = commodityListBean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_one_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        HomeBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = this.commodityListBean.get(i);
        Uri uri = Uri.parse(commodityListBean.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);

        myViewHolder.price.setText("¥"+commodityListBean.getPrice());

        myViewHolder.title.setText(commodityListBean.getCommodityName());
    }

    @Override
    public int getItemCount() {
        return commodityListBean.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView price;
        private final TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.homeone_sdv);
            price = itemView.findViewById(R.id.homeone_price);
            title = itemView.findViewById(R.id.homeone_title);
        }
    }
}
