package com.bw.myproject.weiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.bw.myproject.R;

/**
 * Time:2019.03.21--11:32
 * <p>
 * Author:马鹏涛
 * <p>
 * Description:
 */
public class View extends LinearLayout {
    public View(Context context) {
        super(context);
    }

    public View(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.search_layout,this);
    }

    public View(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
