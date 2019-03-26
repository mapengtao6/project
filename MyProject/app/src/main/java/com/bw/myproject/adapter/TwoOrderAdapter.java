package com.bw.myproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.myproject.R;
import com.bw.myproject.api.ApiService;
import com.bw.myproject.bean.OneOrderBean;
import com.bw.myproject.bean.SelOrderBean;
import com.bw.myproject.bean.TwoOrdeBean;
import com.bw.myproject.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Time:2019.03.26--11:40
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class TwoOrderAdapter extends RecyclerView.Adapter<TwoOrderAdapter.MyViewHolde> {

    Context context;
    List<TwoOrdeBean.ResultBean> resultBeans;

    public TwoOrderAdapter(Context context, List<TwoOrdeBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.two_order_layout, null, false);

        MyViewHolde myViewHolde = new MyViewHolde(view);

        return myViewHolde;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolde myViewHolde, final int i) {

        TwoOrdeBean.ResultBean resultBean = resultBeans.get(i);
        myViewHolde.title.setText(resultBean.getName());

        myViewHolde.rlv.setLayoutManager(new LinearLayoutManager(context));

        String categoryId = resultBean.getId();

        ApiService apiService = RetrofitUtils.getInstance().setCreate(ApiService.class);

        Flowable<SelOrderBean> flowable = apiService.getSelOrder(categoryId);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SelOrderBean>() {
                    @Override
                    public void onNext(SelOrderBean selOrderBean) {

//                        Log.i("llll", selOrderBean.getResult().size() + "");

                        //Toast.makeText(context, "" + result.toString(), Toast.LENGTH_SHORT).show();

                        List<SelOrderBean.ResultBean> result = selOrderBean.getResult();

                        SelOrderAdapter selOrderAdapter = new SelOrderAdapter(context, result);
                        myViewHolde.rlv.setAdapter(selOrderAdapter);


                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    public class MyViewHolde extends RecyclerView.ViewHolder {


        private final TextView title;
        private final RecyclerView rlv;

        public MyViewHolde(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.twoorder_title);
            rlv = itemView.findViewById(R.id.twoorder_rlv);
        }
    }

  /*  public interface onClickLisenter {

        void onClick(View view, int position);
    }

    public onClickLisenter clickLisenter;

    public void setClickLisenter(onClickLisenter onClickLisenter) {
        this.clickLisenter = onClickLisenter;
    }*/
}
