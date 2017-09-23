package com.example.admin.one.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.one.Main2Activity;
import com.example.admin.one.R;
import com.example.admin.one.adapter.ZhutiAdapter;
import com.example.admin.one.bean.ZhutiBean;
import com.example.admin.one.viewgroup.LoggingInterceptor;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class JRFragment extends Fragment {
    private String path = "http://news-at.zhihu.com/api/4/themes";
    private OkHttpClient okHttpClient;
    private Request request;
    private List<ZhutiBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    private RecyclerView recyclerView;
    private ZhutiBean zhutiBean;
    private ZhutiAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_jr, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
        request = new Request.Builder().url(path).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                zhutiBean = gson.fromJson(string, ZhutiBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new ZhutiAdapter(getActivity(), zhutiBean);
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemList(new ZhutiAdapter.onItemClicklistenet() {
                            @Override
                            public void onItemlist(View view) {
                                startActivity(new Intent(getActivity(),Main2Activity.class));
                            }
                        });
                    }
                });
            }
        });


        return view;
    }

}
