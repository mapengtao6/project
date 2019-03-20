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
 * Time:2019.03.20--20:07
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeTwoAdapter extends RecyclerView.Adapter<HomeTwoAdapter.MyViewHolder> {

    Context context;
    List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityListBeanXXES;

    public HomeTwoAdapter(Context context, List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityListBeanXXES) {
        this.context = context;
        this.commodityListBeanXXES = commodityListBeanXXES;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.home_two_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        HomeBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = commodityListBeanXXES.get(i);
        Uri uri = Uri.parse(commodityListBeanXX.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);

        myViewHolder.price.setText("¥"+commodityListBeanXX.getPrice());
        myViewHolder.title.setText(commodityListBeanXX.getCommodityName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView price;
        private final TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sdv = itemView.findViewById(R.id.hometwo_sdv);
            price = itemView.findViewById(R.id.hometwo_price);
            title = itemView.findViewById(R.id.hometwo_title);
        }
    }
}
