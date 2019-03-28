package com.bw.myproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.bean.DetailBean;

/**
 * Time:2019.03.24--14:27
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {

    Context context;
    DetailBean.ResultBean resultBean;

    public DetailAdapter(Context context, DetailBean.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.detail_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.price.setText("¥" + resultBean.getPrice());
        myViewHolder.title.setError(resultBean.getCommodityName());

        Toast.makeText(context, ""+resultBean.getCategoryName(), Toast.LENGTH_SHORT).show();

        myViewHolder.name.setError(resultBean.getDescribe());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView price;
        private final TextView title;
        private final TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.detail_price);
            title = itemView.findViewById(R.id.detail_title);
            name = itemView.findViewById(R.id.detail_name);

        }
    }
}
