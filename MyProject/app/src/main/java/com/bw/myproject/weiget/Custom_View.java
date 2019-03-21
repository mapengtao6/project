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
 * Time:2019.03.21--20:00
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class Custom_View extends LinearLayout {

    private Button button;
    private EditText seek;

    public Custom_View(Context context) {
        super(context);
        initData(context);

    }

    public Custom_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context);

    }


    public Custom_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initData(context);

    }

    private void initData(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_layout, this);

        button = findViewById(R.id.search_button1);
        seek = findViewById(R.id.search_seek);

//        获取文本框

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = seek.getText().toString();

//                判空
                if (keyword.isEmpty()) {

                    Toast.makeText(getContext(), "请输入搜索的内容~", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (custLisenter != null) {
                    custLisenter.onCust(keyword);
                }

            }
        });
    }


    //    接口回调
    public interface onCustLisenter {

        void onCust(String keyword);
    }

    public onCustLisenter custLisenter;

    public void setCustLisenter(onCustLisenter onCustLisenter) {
        this.custLisenter = onCustLisenter;
    }
}
