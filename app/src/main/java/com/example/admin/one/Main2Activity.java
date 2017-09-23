package com.example.admin.one;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.one.adapter.ChaAdapter;
import com.example.admin.one.bean.ChaBean;
import com.example.admin.one.viewgroup.LoggingInterceptor;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView_img;
    private String path = "http://news-at.zhihu.com/api/4/theme/11";
    private ChaBean chaBean;
    private Handler handler = new Handler();
    private ChaBean chaBean1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView_img = (RecyclerView) findViewById(R.id.recyclerView_img);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_img.setLayoutManager(linearLayoutManager);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
        Request request=new Request.Builder().url(path).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                chaBean1 = gson.fromJson(string, ChaBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ChaAdapter chaAdapter = new ChaAdapter(Main2Activity.this,chaBean1);
                        recyclerView_img.setAdapter(chaAdapter);
                    }
                });
            }
        });
    }
}
