package com.scriptgo.www.graviflex.api;

import com.scriptgo.www.graviflex.apilinks.ApiLinks;
import com.scriptgo.www.graviflex.constans.ConstansHelps;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BALAREZO on 10/08/2017.
 */

public class ApiAdapter {

    private static ApiLinks apiLinksService;

    public static ApiLinks getApiLinksService(){
        HttpLoggingInterceptor logging =  new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = ConstansHelps.URL_BASE_API;

        if(apiLinksService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            apiLinksService = retrofit.create(ApiLinks.class);
        }

        return apiLinksService;
    }
}
