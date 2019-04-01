package com.bw.myproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.myproject.R;
import com.bw.myproject.bean.ShopAddressBean;

import java.util.List;

/**
 * Time:2019.03.30--16:30
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopAddressAdapter extends RecyclerView.Adapter<ShopAddressAdapter.MyViewHolder> {


    Context context;
    List<ShopAddressBean.ResultBean> resultBeans;

    public ShopAddressAdapter(Context context, List<ShopAddressBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.shop_address_layout, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        ShopAddressBean.ResultBean resultBean = resultBeans.get(i);

        myViewHolder.address.setText(resultBean.getAddress());
        myViewHolder.phone.setText(resultBean.getPhone());
        myViewHolder.title.setText(resultBean.getRealName());

    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView phone;
        private final TextView title;
        private final TextView address;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            phone = itemView.findViewById(R.id.shop_address_phone);
            title = itemView.findViewById(R.id.shop_address_title);
            address = itemView.findViewById(R.id.shop_address_address);
        }
    }
}
