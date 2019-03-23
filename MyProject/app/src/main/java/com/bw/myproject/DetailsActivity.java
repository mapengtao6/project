package com.bw.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bw.myproject.presenter.DetailPresenter;

public class DetailsActivity extends AppCompatActivity {

    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        String commodityId = intent.getStringExtra("commodityId");

//        Toast.makeText(this, ""+commodityId.toString(), Toast.LENGTH_SHORT).show();

        presenter = new DetailPresenter(this);

        presenter.datail(commodityId);
    }
}
