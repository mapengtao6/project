package com.bw.myproject.activity;


import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.myproject.R;
import com.bw.myproject.adapter.DetailAdapter;
import com.bw.myproject.bean.DetailBean;
import com.bw.myproject.presenter.DetailPresenter;
import com.bw.myproject.view.DetailView;
import com.bw.myproject.weiget.IdeaScrollView;
import com.bw.myproject.weiget.IdeaViewPager;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import qiu.niorgai.StatusBarCompat;

public class DetailsActivity extends AppCompatActivity implements DetailView {



    private ImageView mIvCart;
    private List<String> titles = new ArrayList<>();
    private float startY;//上下滑动的距离
    private int moveDistance;//动画移动的距离
    private boolean isShowFloatImage = true;//标记图片是否显示
    private Timer timer;//计时器
    private long upTime;//记录抬起的时间

//    **********************

    private IdeaViewPager viewPager;
    private IdeaScrollView ideaScrollView;
    private TextView text;
    private LinearLayout header;
    private RadioGroup radioGroup;
    private LinearLayout headerParent;
    private ImageView icon;
    private View layer;
    private float currentPercentage = 0;
    private RadioGroup.OnCheckedChangeListener radioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setTextColor(radioButton.isChecked() ? getRadioCheckedAlphaColor(currentPercentage) : getRadioAlphaColor(currentPercentage));
                if (radioButton.isChecked() && isNeedScrollTo) {
                    ideaScrollView.setPosition(i);
                }
            }
        }
    };
    private boolean isNeedScrollTo = true;
    private ImageView back;
    private TextView price;
    private TextView title;
    private TextView name;
    private XBanner xBanner;
    private WebView webView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        -----------------------------------------------------------------
        setContentView(R.layout.activity_details);
//-------------------------------------------------------------------------
        StatusBarCompat.translucentStatusBar(this);
        header = (LinearLayout) findViewById(R.id.header);
        headerParent = (LinearLayout) findViewById(R.id.headerParent);
        icon = (ImageView) findViewById(R.id.icon);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ideaScrollView = (IdeaScrollView) findViewById(R.id.ideaScrollView);
        viewPager = (IdeaViewPager) findViewById(R.id.viewPager);
        layer = findViewById(R.id.layer);

        Rect rectangle = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
        ideaScrollView.setViewPager(viewPager, getMeasureHeight(headerParent) - rectangle.top);
        //  icon.setImageAlpha(0);
        radioGroup.setAlpha(0);
        radioGroup.check(radioGroup.getChildAt(0).getId());

        View one = findViewById(R.id.one);
        View two = findViewById(R.id.two);
        View three = findViewById(R.id.three);
        // View four = findViewById(R.id.four);
        ArrayList<Integer> araryDistance = new ArrayList<>();

        araryDistance.add(0);
        araryDistance.add(getMeasureHeight(one) - getMeasureHeight(headerParent));
        araryDistance.add(getMeasureHeight(one) + getMeasureHeight(two) - getMeasureHeight(headerParent));
        araryDistance.add(getMeasureHeight(one) + getMeasureHeight(two) + getMeasureHeight(three) - getMeasureHeight(headerParent));

        ideaScrollView.setArrayDistance(araryDistance);

        ideaScrollView.setOnScrollChangedColorListener(new IdeaScrollView.OnScrollChangedColorListener() {
            @Override
            public void onChanged(float percentage) {

                int color = getAlphaColor(percentage > 0.9f ? 1.0f : percentage);
                header.setBackgroundDrawable(new ColorDrawable(color));
                radioGroup.setBackgroundDrawable(new ColorDrawable(color));
                //    icon.setImageAlpha((int) ((percentage > 0.9f ? 1.0f : percentage) * 255));
                radioGroup.setAlpha((percentage > 0.9f ? 1.0f : percentage) * 255);

                setRadioButtonTextColor(percentage);

            }

            @Override
            public void onChangedFirstColor(float percentage) {

            }

            @Override
            public void onChangedSecondColor(float percentage) {

            }
        });

        ideaScrollView.setOnSelectedIndicateChangedListener(new IdeaScrollView.OnSelectedIndicateChangedListener() {
            @Override
            public void onSelectedChanged(int position) {
                isNeedScrollTo = false;
                radioGroup.check(radioGroup.getChildAt(position).getId());
                isNeedScrollTo = true;
            }
        });

        radioGroup.setOnCheckedChangeListener(radioGroupListener);

        //-------------------------------------------------------------------------


//        initData();

//        控件
//        *******************************************************************************************
        Intent intent = getIntent();

        String commodityId = intent.getStringExtra("commodityId");

        back = findViewById(R.id.detail_back);
        price = findViewById(R.id.detail_price);
        title = findViewById(R.id.detail_title);
        name = findViewById(R.id.detail_name);
        xBanner = findViewById(R.id.detail_xbanner);
        webView = findViewById(R.id.detail_webview);
        mIvCart = findViewById(R.id.iv_cart);


        DetailPresenter presenter = new DetailPresenter(this);

        presenter.datail(commodityId);

//        点击事件
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        ----------------------
        initData();

    }

    private void initData() {
        //控件绘制完成之后再获取其宽高
        mIvCart.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //动画移动的距离 屏幕的宽度减去图片距左边的宽度 就是图片距右边的宽度，再加上隐藏的一半
                moveDistance = getScreenWidth() - mIvCart.getRight() + mIvCart.getWidth() / 2;
                //监听结束之后移除监听事件
//                mIvCart.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mIvCart.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    private int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://手指按下
                if (System.currentTimeMillis() - upTime < 1000) {
                    //本次按下距离上次的抬起小于1s时，取消Timer
                    timer.cancel();
                }
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE://手指滑动
                if (Math.abs(startY - event.getY()) > 10) {
                    if (isShowFloatImage) {
                        hideFloatImage(moveDistance);
                    }
                }
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP://手指抬起
                if (!isShowFloatImage) {
                    //抬起手指1s后再显示悬浮按钮
                    //开始1s倒计时
                    upTime = System.currentTimeMillis();
                    timer = new Timer();
                    timer.schedule(new FloatTask(), 1000);
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    private class FloatTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showFloatImage(moveDistance);
                }
            });
        }
    }


    private void hideFloatImage(int distance) {
        isShowFloatImage = false;

        //位移动画
        TranslateAnimation ta = new TranslateAnimation(0, distance, 0, 0);
        ta.setDuration(300);

        //渐变动画
        AlphaAnimation al = new AlphaAnimation(1f, 0.5f);
        al.setDuration(300);

        AnimationSet set = new AnimationSet(true);
        //动画完成后不回到原位
        set.setFillAfter(true);
        set.addAnimation(ta);
        set.addAnimation(al);
        mIvCart.startAnimation(set);
    }

    private void showFloatImage(int distance) {
        isShowFloatImage = true;

        //位移动画
        TranslateAnimation ta = new TranslateAnimation(distance, 0, 0, 0);
        ta.setDuration(300);

        //渐变动画
        AlphaAnimation al = new AlphaAnimation(0.5f, 1f);
        al.setDuration(300);

        AnimationSet set = new AnimationSet(true);
        //动画完成后不回到原位
        set.setFillAfter(true);
        set.addAnimation(ta);
        set.addAnimation(al);
        mIvCart.startAnimation(set);
    }



 /*   @Override
    public void Detail(DetailBean detailBean) {
        DetailBean.ResultBean result = detailBean.getResult();

//        DetailAdapter detailAdapter = new DetailAdapter(this, result);

    }*/

    public void setRadioButtonTextColor(float percentage) {
        if (Math.abs(percentage - currentPercentage) >= 0.1f) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setTextColor(radioButton.isChecked() ? getRadioCheckedAlphaColor(percentage) : getRadioAlphaColor(percentage));
            }
            this.currentPercentage = percentage;
        }
    }

    public int getMeasureHeight(View view) {
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        return view.getMeasuredHeight();
    }

    public int getAlphaColor(float f) {
        return Color.argb((int) (f * 255), 0x09, 0xc1, 0xf4);
    }

    public int getLayerAlphaColor(float f) {
        return Color.argb((int) (f * 255), 0x09, 0xc1, 0xf4);
    }

    public int getRadioCheckedAlphaColor(float f) {
        return Color.argb((int) (f * 255), 0x44, 0x44, 0x44);
    }

    public int getRadioAlphaColor(float f) {
        return Color.argb((int) (f * 255), 0xFF, 0xFF, 0xFF);
    }


    @Override
    public void Detail(DetailBean detailBean) {

        DetailBean.ResultBean result = detailBean.getResult();

        String picture = result.getPicture();

        final List<String> strings = Arrays.asList(picture.split(","));

        price.setText("¥" + result.getPrice());
        title.setText(result.getCategoryName());
        name.setText(result.getCommodityName());

        xBanner.setData(strings, null);
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(strings.get(position)).into((ImageView) view);
            }
        });

//        加载网页
        webView.loadDataWithBaseURL(null, result.getDetails(), "text/html", "utf-8", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

    }
}
