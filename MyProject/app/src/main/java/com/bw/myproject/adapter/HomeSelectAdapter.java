package com.bw.myproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.myproject.activity.DetailsActivity;
import com.bw.myproject.R;
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
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        final SearchBean.ResultBean resultBean = this.resultBean.get(i);
        myViewHolder.price.setText("¥" + resultBean.getPrice());

        myViewHolder.title.setText(resultBean.getCommodityName());

        Uri uri = Uri.parse(resultBean.getMasterPic());
        myViewHolder.sdv.setImageURI(uri);

//        点击事件
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "666", Toast.LENGTH_SHORT).show();

                String commodityId = resultBean.getCommodityId();

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("commodityId",commodityId);

                context.startActivity(intent);

//                Log.i("xxxx",commodityId.toString());
            }
        });
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

    /*public interface onHomeSelLisenter {
        void onClick(View view, int position);
    }

    public onHomeSelLisenter homeSelLisenter;

    public void setHomeSelLisenter(onHomeSelLisenter onHomeSelLisenter) {
        this.homeSelLisenter = onHomeSelLisenter;
    }*/
}
