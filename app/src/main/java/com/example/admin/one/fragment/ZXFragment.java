package com.example.admin.one.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.one.R;
import com.example.admin.one.adapter.ZuiXinAdapter;
import com.example.admin.one.bean.ZuiXinBean;
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
public class ZXFragment extends Fragment {

    private SwipeRefreshLayout swipe1;
    private RecyclerView recyclerView;
    private OkHttpClient okHttpClient;
    private String path = "http://news-at.zhihu.com/api/4/news/latest";
    private Request request;
    private List<ZuiXinBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    private ZuiXinAdapter adapter;
    private ZuiXinBean zuiXinBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_zx, container, false);
        swipe1 = view.findViewById(R.id.swipe1);
        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
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
                zuiXinBean = gson.fromJson(string, ZuiXinBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new ZuiXinAdapter(getActivity(), zuiXinBean);
                        recyclerView.setAdapter(adapter);
                    }
                });

            }
        });

        swipe1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               zuiXinBean.stories.add(0,zuiXinBean.stories.get(2));
               zuiXinBean.top_stories.add(0,zuiXinBean.top_stories.get(2));
               adapter.notifyDataSetChanged();
               swipe1.setRefreshing(false);

            }
        });



        return view;

    }

}
