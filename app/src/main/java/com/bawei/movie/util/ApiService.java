package com.bawei.movie.util;

import com.bawei.movie.bean.EmailBean;
import com.bawei.movie.bean.FindModelBean;
import com.bawei.movie.bean.JiUpBean;
import com.bawei.movie.bean.LoginBean;
import com.bawei.movie.bean.RegisterBean;
import com.bawei.movie.bean.RemenBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("movieApi/user/v2/register")
    @FormUrlEncoded
    Observable<RegisterBean> register(@Field("nickName")String nickName,@Field("pwd")String pwd,@Field("email")String email,@Field("code")String code);

    @POST("movieApi/user/v2/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("email")String email,@Field("pwd")String pwd);

    @POST("movieApi/user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<EmailBean> code(@Field("email")String email);

    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<FindModelBean> findmovie(@Query("page") int page, @Query("count")int count);

    @GET("movie/v2/findComingSoonMovieList")
    Observable<JiUpBean> getJiUp(@Query("page") int page, @Query("count")int count);

    @GET("movie/v2/findHotMovieList")
    Observable<RemenBean> getRemen(@Query("page") int page, @Query("count") int count);

}
