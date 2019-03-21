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
import com.bw.myproject.bean.SearchBean;
import com.bw.myproject.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Time:2019.03.20--20:07
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class HomeSelectAdapter extends RecyclerView.Adapter<HomeSelectAdapter.MyViewHolder> {

    Context context;
    List<SearchBean.ResultBean> resultBean;

    public HomeSelectAdapter(Context context, List<SearchBean.ResultBean> resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.home_select, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        SearchBean.ResultBean resultBean = this.resultBean.get(i);
        myViewHolder.price.setText(resultBean.getMasterPic());

        myViewHolder.title.setText(resultBean.getCommodityName());

        Uri uri = Uri.parse(resultBean.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return resultBean.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView title;
        private final TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sdv = itemView.findViewById(R.id.homeselect_sdv);
            title = itemView.findViewById(R.id.homeselect_title);
            price = itemView.findViewById(R.id.homeselect_price);
        }
    }
}
