package com.bawei.movie.util;

import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil instance;
    private static String baseUrl = "http://mobile.bwstudent.com/";
    private final Retrofit retrofit;

    private RetrofitUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient builder = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder1 = request.newBuilder();
                        int userId = SpUtil.getInt("userId");
                        String sessionId = SpUtil.getString("sessionId");
                        //判断
                        if (!TextUtils.isEmpty(sessionId)){
                            builder1.addHeader("sessionId",sessionId);
                        }
                        if (userId!=-1){
                            //添加请求头
                            builder1.addHeader("userId",userId+"");
                        }
                        Request build = builder1.build();
                        return chain.proceed(build);
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public ApiService apiService(){
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
