package com.example.retrofitjava.service;

import com.example.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {
    //GET, POST, UPDATE, DELETE

    //URL BASE -> www.website.com
    // GET -> price?key=xxx

    //https://api.nomics.com/v1
    //prices?key=d29b1dc647c5bf3c69bfd6288f3d79426293513f
    //https://raw.githubusercontent.com/faikturan/androidbootcamp/master/crypto.json

    @GET("currencies/ticker?key=d29b1dc647c5bf3c69bfd6288f3d79426293513f")
    Observable<List<CryptoModel>> getData();
    //Call<List<CryptoModel>> getData();

}
