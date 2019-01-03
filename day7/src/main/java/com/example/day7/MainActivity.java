package com.example.day7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.myview);
        myView.invalidate();//重绘  在主线中进行运行
        //myView.postInvalidate();//重绘   在子线程中进行运行
    }
}
