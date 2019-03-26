package com.bw.myproject.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.myproject.R;
import com.bw.myproject.fragment.CircleFragment;
import com.bw.myproject.fragment.HomeFragment;
import com.bw.myproject.fragment.MineFragment;
import com.bw.myproject.fragment.OrderFragment;
import com.bw.myproject.fragment.ShoppCardFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_radio1)
    RadioButton button1;
    @BindView(R.id.main_radio2)
    RadioButton button2;
    @BindView(R.id.main_radio3)
    RadioButton button3;
    @BindView(R.id.main_radio4)
    RadioButton button4;
    @BindView(R.id.main_radio5)
    RadioButton button5;
    @BindView(R.id.main_group)
    RadioGroup radioGroup;
    @BindView(R.id.main_frme)
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final FragmentManager manager = getSupportFragmentManager();
//        开启事务
        FragmentTransaction transaction = manager.beginTransaction();

        final HomeFragment homeFragment = new HomeFragment();
        final CircleFragment circleFragment = new CircleFragment();
        final ShoppCardFragment shoppCardFragment = new ShoppCardFragment();
        final OrderFragment orderFragment = new OrderFragment();
        final MineFragment mineFragment = new MineFragment();

        radioGroup.check(radioGroup.getChildAt(4).getId());

        transaction.add(R.id.main_frme, homeFragment);
        transaction.add(R.id.main_frme, circleFragment);
        transaction.add(R.id.main_frme, shoppCardFragment);
        transaction.add(R.id.main_frme, orderFragment);
        transaction.add(R.id.main_frme, mineFragment);
//        transaction.replace(R.id.main_frme, homeFragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){

                    case R.id.main_radio1:

                        transaction.replace(R.id.main_frme,homeFragment);
                        break;

                    case R.id.main_radio2:
                        transaction.replace(R.id.main_frme,circleFragment);


                        break;

                    case R.id.main_radio3:
                        transaction.replace(R.id.main_frme,shoppCardFragment);


                        break;

                    case R.id.main_radio4:
                        transaction.replace(R.id.main_frme,orderFragment);



                        break;
                    case R.id.main_radio5:
                        transaction.replace(R.id.main_frme,mineFragment);


                        break;

                }

                transaction.commit();
            }
        });
    }
}
