package com.bw.myproject.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.myproject.R;
import com.bw.myproject.bean.ShopSelBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time:2019.03.28--15:50
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class ShopSelAdapter extends RecyclerView.Adapter<ShopSelAdapter.MyViewHolder> {

    Context context;
    List<ShopSelBean.ResultBean> resultBeans;
    Map<String, Boolean> map = new HashMap<>();

    public ShopSelAdapter(Context context, List<ShopSelBean.ResultBean> resultBeans,onCheckLisenter lisenter) {
        this.context = context;
        this.resultBeans = resultBeans;
        setCheData(false);
        this.lisenter = lisenter;
    }

    //    全选控制适配器
    private void setCheData(boolean checkFlag) {
        map.clear();
        for (int i = 0; i < resultBeans.size(); i++) {
            String id = resultBeans.get(i).getCommodityId();
            map.put(id, checkFlag);
        }
    }

    //    刷新适配器
    public void notifCheckData(boolean checkFlag) {
//        设置选择状态
        setCheData(checkFlag);
//    刷新适配器
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.shop_sel_layout, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        ShopSelBean.ResultBean resultBean = resultBeans.get(i);
        myViewHolder.price.setText("¥" + resultBean.getPrice());
        myViewHolder.title.setText(resultBean.getCommodityName());

        Uri uri = Uri.parse(resultBean.getPic());
        myViewHolder.sdv.setImageURI(uri);

        final String id = resultBean.getCommodityId();
        myViewHolder.checkBox.setChecked(map.get(id));

//        点击事件
        myViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = ((CheckBox) v).isChecked();
                map.put(id, checked);
//                定义一个全选的状态
                boolean isChecked = true;
//                遍历集合
                for (String key : map.keySet()) {

                    Boolean value = map.get(key);
                    if (!value) {
                        isChecked = false;
                        if (lisenter != null) {
//                            取消全选
                            lisenter.oncheck(isChecked);
                        }

                        return;
                    }
                }

//                全选
                if (isChecked) {
//                    全选
                    if (lisenter != null) {
                        lisenter.oncheck(isChecked);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView price;
        private final TextView title;
        private final CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.shopsel_price);
            title = itemView.findViewById(R.id.shopsel_title);
            sdv = itemView.findViewById(R.id.shopsel_sdv);

            checkBox = itemView.findViewById(R.id.shopsel_checkbox);
        }
    }

    public interface onCheckLisenter {
        void oncheck(boolean isCheck);
    }

    public onCheckLisenter lisenter;

    public void setOnCheckListener(onCheckLisenter onCheckListener) {
        this.lisenter = onCheckListener;
    }
}
