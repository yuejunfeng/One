package com.example.admin.one.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.one.R;
import com.example.admin.one.bean.ChaBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by admin on 2017/9/23.
 */

public class ChaAdapter extends RecyclerView.Adapter {
    private Context context;
    private ChaBean chaBean;
    private static final int HOEM = 0;
    private static final int FOOT = 1;

    public ChaAdapter(Context context, ChaBean chaBean) {
        this.context = context;
        this.chaBean = chaBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HOEM) {
            View view = View.inflate(context, R.layout.item_cha, null);
            return new PullCha(view);
        } else {
            View view = View.inflate(context, R.layout.item_chai, null);
            return new PullChai(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == HOEM) {
                PullCha pullCha= (PullCha) holder;
                pullCha.tv.setText(chaBean.name);
                setImage(chaBean.image,context,pullCha.iv);
        } else {
            PullChai pullChai= (PullChai) holder;
            pullChai.tv1.setText(chaBean.name);
            setImage(chaBean.background,context,pullChai.iv1);
        }

    }

    @Override
    public int getItemCount() {
        return chaBean.editors.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HOEM;
        } else {
            return FOOT;
        }

    }

    private class PullCha extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public PullCha(View view) {
            super(view);
            iv = view.findViewById(R.id.iv_img3);
            tv = view.findViewById(R.id.tv_name);
        }
    }

    private class PullChai extends RecyclerView.ViewHolder {
        TextView tv1;
        ImageView iv1;

        public PullChai(View view) {
            super(view);
            iv1 = view.findViewById(R.id.iv_img4);
            tv1 = view.findViewById(R.id.tv_name2);
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


}
