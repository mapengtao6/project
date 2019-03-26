package com.bw.myproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.myproject.R;
import com.bw.myproject.bean.OneOrderBean;

import java.util.List;

/**
 * Time:2019.03.26--11:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class OneOrderAdapter extends RecyclerView.Adapter<OneOrderAdapter.MyViewHolde> {

    Context context;
    List<OneOrderBean.ResultBean> resultBeans;

    public OneOrderAdapter(Context context, List<OneOrderBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.one_order_layout, null, false);

        MyViewHolde myViewHolde = new MyViewHolde(view);

        return myViewHolde;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolde myViewHolde, final int i) {

        OneOrderBean.ResultBean resultBean = resultBeans.get(i);
        myViewHolde.title.setText(resultBean.getName());

//        点击事件
        myViewHolde.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myViewHolde.getAdapterPosition();
                View itemView = myViewHolde.itemView;

                if (clickLisenter != null) {
                    clickLisenter.onClick(itemView, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolde extends RecyclerView.ViewHolder {

        private final TextView title;

        public MyViewHolde(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.oneorder_title);
        }
    }

    public interface onClickLisenter {

        void onClick(View view, int position);
    }

    public onClickLisenter clickLisenter;

    public void setClickLisenter(onClickLisenter onClickLisenter) {
        this.clickLisenter = onClickLisenter;
    }
}
