package com.alok328.raj.retrofit.Interface;

import com.alok328.raj.retrofit.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines?country=in&apiKey=962cbe5c589d42838d698cca2fa6670c")
    Call<News> getNews();



}
