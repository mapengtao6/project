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
 * Time:2019.03.20--20:22
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeThreeAdapter extends RecyclerView.Adapter<HomeThreeAdapter.MyViewHolder> {

    Context context;
    List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityListBeanXES;

    public HomeThreeAdapter(Context context, List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityListBeanXES) {
        this.context = context;
        this.commodityListBeanXES = commodityListBeanXES;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_three_layout,null,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        HomeBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = commodityListBeanXES.get(i);

        Uri uri = Uri.parse(commodityListBeanX.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);

        myViewHolder.price.setText("¥"+commodityListBeanX.getPrice());
        myViewHolder.title.setText(commodityListBeanX.getCommodityName());
    }

    @Override
    public int getItemCount() {
        return commodityListBeanXES.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView price;
        private final TextView title;
        private final SimpleDraweeView sdv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.homethree_price);
            title = itemView.findViewById(R.id.homethree_title);
            sdv = itemView.findViewById(R.id.homethree_sdv);
        }
    }
}
