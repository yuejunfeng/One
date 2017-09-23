package com.example.admin.one.viewgroup;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by admin on 2017/9/7.
 * 自定义的缓存拦截器：如果服务器没有给文件在响应头中定义缓存标签，那么我们在拦截器中手动给响应头加上标签
 * 1.自定义一个类，实现Interceptor
 * 2.在Interceptor方法中写自己的逻辑
 */

public class CacheInterecepor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        Response build = response.newBuilder()
                //设置缓存标签,及60秒的时长
                .header("Cache-Control", "max-age=60")
                .build();
        return build;
    }
}
