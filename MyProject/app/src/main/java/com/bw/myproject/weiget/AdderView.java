package com.bw.myproject.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bw.myproject.R;

/**
 * Time:2019.03.28--15:58
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class AdderView extends LinearLayout implements View.OnClickListener {

    private int number = 1;

    private EditText num_goods;

    public AdderView(Context context) {
        super(context);
    }

    public AdderView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.adder_layout, this);
        Button minus_goods = findViewById(R.id.minus_goods);
        Button add_goods = findViewById(R.id.add_goods);

        num_goods = findViewById(R.id.num_goods);

//        设置点击
        minus_goods.setOnClickListener(this);
        add_goods.setOnClickListener(this);
    }

    public AdderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.add_goods:
                number++;
                num_goods.setText(number + "");

                if (numChangerLisenter != null) {
                    numChangerLisenter.changeNum(number);
                }

                break;

            case R.id.minus_goods:

                if (number > 1) {
                    number--;
                    num_goods.setText(number + "");

                    if (numChangerLisenter != null) {
                        numChangerLisenter.changeNum(number);
                    }

                } else {
                    Toast.makeText(getContext(), "不能再少了~", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public interface onNumChangerLisenter {
        void changeNum(int num);
    }

    public onNumChangerLisenter numChangerLisenter;

    public void setNumChangerLisenter(onNumChangerLisenter onNumChangerLisenter) {
        this.numChangerLisenter = onNumChangerLisenter;
    }
}
