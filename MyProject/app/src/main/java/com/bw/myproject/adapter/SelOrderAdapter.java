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
import com.bw.myproject.bean.SelOrderBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Time:2019.03.26--14:48
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class SelOrderAdapter extends RecyclerView.Adapter<SelOrderAdapter.MyViewHolder> {

    Context context;
    List<SelOrderBean.ResultBean> resultBeans;

    public SelOrderAdapter(Context context, List<SelOrderBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.sel_order_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        SelOrderBean.ResultBean resultBean = resultBeans.get(i);
        myViewHolder.title.setText(resultBean.getCommodityName());

        Uri uri = Uri.parse(resultBean.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sdv = itemView.findViewById(R.id.selorder_sdv);
            title = itemView.findViewById(R.id.selorder_title);
        }
    }
}
