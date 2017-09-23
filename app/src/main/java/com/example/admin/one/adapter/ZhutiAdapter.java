package com.example.admin.one.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.one.R;
import com.example.admin.one.bean.ZhutiBean;
import com.example.admin.one.view.ImageViewPlus;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by admin on 2017/9/23.
 */

public class ZhutiAdapter extends RecyclerView.Adapter {
    private Context context;
    private ZhutiBean zhutiBean;



    public ZhutiAdapter(Context context, ZhutiBean zhutiBean) {
        this.context = context;
        this.zhutiBean = zhutiBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_img,null);
        return new PullImage(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PullImage pullImage= (PullImage) holder;
        setImage(zhutiBean.others.get(position).thumbnail,context,pullImage.iv);

    }

    @Override
    public int getItemCount() {
        return zhutiBean.others.size();
    }

    private class PullImage extends RecyclerView.ViewHolder {
        ImageViewPlus iv;
        public PullImage(View view) {
            super(view);
           iv = view.findViewById(R.id.iv_img2);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(monItemClicklistenet != null){
                        monItemClicklistenet.onItemlist(view);
                    }
                }
            });
        }
    }
        public static void setImage(String url , Context context,ImageView imageView){
                    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.init(config);
                    DisplayImageOptions diosplay =new DisplayImageOptions.Builder()
                            .showImageOnLoading(R.mipmap.ic_launcher)
                            .showImageForEmptyUri(R.mipmap.ic_launcher)
                            .showImageOnFail(R.mipmap.ic_launcher)
                            .cacheInMemory(true)
                            .cacheOnDisk(true)
                            .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                            .bitmapConfig(Bitmap.Config.RGB_565)

                            .build();
                    imageLoader.displayImage(url,imageView,diosplay);
                }

        public interface onItemClicklistenet{
            void onItemlist(View view);
        }
        private onItemClicklistenet monItemClicklistenet;

        public void setOnItemList(onItemClicklistenet msetonItem){
            monItemClicklistenet=msetonItem;
        }

}
