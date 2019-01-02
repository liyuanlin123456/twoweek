package com.example.lenovo.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapter.MyAdapter;
import com.example.lenovo.myapplication.contract.IShowContract;
import com.example.lenovo.myapplication.entity.User;
import com.example.lenovo.myapplication.net.OkhttpUtils;
import com.example.lenovo.myapplication.presenter.ShowPresenter;

import java.util.HashMap;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements IShowContract.IShowView {

    private EditText ed_title;
    private Button btn_search;
    private RecyclerView gv;
    private String keywords;
    private ShowPresenter presenter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ed_title = findViewById(R.id.ed_title);
        btn_search = findViewById(R.id.btn_search);
        gv = findViewById(R.id.gv);
        gv.setLayoutManager(new LinearLayoutManager(this));
        presenter = new ShowPresenter(this);
        myAdapter = new MyAdapter(this);
        //点击事件
        btn_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                keywords = ed_title.getText().toString();
                HashMap<String,String> params=new HashMap<>();
                params.put("keywords",keywords);
                params.put("page",1+"");
                presenter.show(params);
            }
        });
    }

    @Override
    public void onFailUre(String msg) {
        
    }

    @Override
    public void onSuccess(User user) {
        List<User.DataBean> data = user.getData();
        myAdapter.setList(data);
        gv.setAdapter(myAdapter);

        ////hsdjkahdkjhkj
    }

    @Override
    public void onSuccessMsg(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkhttpUtils.getmInstance().cancelAllTask();
        presenter.destroy();
    }
}
