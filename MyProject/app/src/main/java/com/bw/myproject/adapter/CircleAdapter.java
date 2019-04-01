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
import com.bw.myproject.bean.CircleBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Time:2019.03.30--15:03
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.MyViewHolder> {

    Context context;
    List<CircleBean.ResultBean> resultBeans;

    public CircleAdapter(Context context, List<CircleBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.circle_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        CircleBean.ResultBean resultBean = resultBeans.get(i);

        myViewHolder.ping.setText(resultBean.getContent());
        myViewHolder.title.setText(resultBean.getNickName());

        Uri uri = Uri.parse(resultBean.getHeadPic());
        myViewHolder.sdv1.setImageURI(uri);

        Uri uri1 = Uri.parse(resultBean.getImage());
        myViewHolder.sdv2.setImageURI(uri1);
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView ping;
        private final TextView title;
        private final SimpleDraweeView sdv1;
        private final SimpleDraweeView sdv2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ping = itemView.findViewById(R.id.circle_item_ping);
            title = itemView.findViewById(R.id.circle_item_title);

            sdv1 = itemView.findViewById(R.id.circle_item_sdv1);
            sdv2 = itemView.findViewById(R.id.circle_item_sdv2);
        }
    }
}
