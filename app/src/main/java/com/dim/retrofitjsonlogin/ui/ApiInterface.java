package com.dim.retrofitjsonlogin.ui;

import com.dim.retrofitjsonlogin.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface APIInterface {
    @FormUrlEncoded
    @POST("retrofit/register.php")
    Call<LoginResponse> registrar(@Field("nombre") String nombre,
                   @Field("password") String password,
                   @Field("loginType") String loginType);
}
