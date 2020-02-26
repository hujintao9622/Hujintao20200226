package com.bawei.hujintao.widget;

import com.bawei.hujintao.model.bean.LoginBean;
import com.bawei.hujintao.model.bean.RegisterBena;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/26 0026 下午 4:39
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterBena> regis(@Field("phone")String phone,@Field("pwd")String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> log(@Field("phone")String phone, @Field("pwd")String pwd);
}
