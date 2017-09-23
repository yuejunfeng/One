package com.example.admin.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.one.R;
import com.example.admin.one.bean.ZuiXinBean;
import com.example.admin.one.image.ImageBanner;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by admin on 2017/9/22.
 */

public class ZuiXinAdapter extends RecyclerView.Adapter {
    private Context context;
    private ZuiXinBean zuiXinBean;
    public  static final int HOED = 0;
    public static final int FOOT = 1;
    private List<String> lists;

    public ZuiXinAdapter(Context context, ZuiXinBean zuiXinBean) {
        this.context = context;
        this.zuiXinBean=zuiXinBean;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == HOED){
           view = View.inflate(context, R.layout.item_banner,null);
            return new PunnBanner(view);
        }else{
            view=View.inflate(context,R.layout.item_recycler,null);
            return new PullRecycler(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==HOED){
            lists = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                lists.add(zuiXinBean.top_stories.get(i).image);
            }
            PunnBanner punnBanner = (PunnBanner) holder;
            punnBanner.banner1.setImageLoader(new ImageBanner());
            punnBanner.banner1.setImages(lists);
            punnBanner.banner1.start();

        }else{
            PullRecycler recycler= (PullRecycler) holder;
            recycler.tv.setText(zuiXinBean.stories.get(position).title);
            Glide.with(context).load(zuiXinBean.top_stories.get(position-1).image).into(recycler.iv);
        }
    }

    @Override
    public int getItemCount() {
        return zuiXinBean.stories.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return HOED;
        }else{
            return FOOT;
        }
    }

    private class PunnBanner extends RecyclerView.ViewHolder {
        Banner banner1;
        public PunnBanner(View view) {
            super(view);
           banner1 = view.findViewById(R.id.bannner);
        }
    }

    private class PullRecycler extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public PullRecycler(View view) {
            super(view);
           iv = view.findViewById(R.id.iv_img);
           tv = view.findViewById(R.id.tv_title);
        }
    }
}
