package com.example.kao07;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xlistview.me.maxwin.view.XListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private XListView xlv;
    private MyAdapter myAdapter;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xlv = findViewById(R.id.xlv);
        xlv.setPullLoadEnable(true);
        xlv.setPullRefreshEnable(true);
        myAdapter = new MyAdapter(this);
        xlv.setAdapter(myAdapter);
        xlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                initData();
            }

            @Override
            public void onLoadMore() {
                initData();
            }
        });
        initData();
    }

    private void initData() {
        list =new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("refresh cnt"+i);
        }
        myAdapter.setList(list);
        xlv.stopRefresh();
        xlv.stopLoadMore();
    }
}
