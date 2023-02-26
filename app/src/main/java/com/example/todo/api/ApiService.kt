package com.example.todo.api

import com.example.todo.models.Station
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("station")
    fun getStationList(): Call<List<Station>>

    companion object {
        val builder =
            Retrofit.Builder()
                .baseUrl("http://station.zentropy.co.kr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }
}


