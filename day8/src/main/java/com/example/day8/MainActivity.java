package com.example.day8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DotView dotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotView = findViewById(R.id.dotview);
    }
    public void add(View view){
        DotBean dotBean = new DotBean();
        dotBean.setX(new Random().nextInt(800));
        dotBean.setY(new Random().nextInt(1500));
        dotBean.setChecked(false);
        dotView.add(dotBean);
    }
}
