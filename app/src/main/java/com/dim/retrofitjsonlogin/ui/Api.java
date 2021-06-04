package com.dim.retrofitjsonlogin.ui;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class API {
    private static String url = "http://mobileappdatabase.in/";
    private static Retrofit retrofit;
    public static APIInterface getCliente() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        return apiInterface;
    }
}
