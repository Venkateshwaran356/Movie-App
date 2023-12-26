package com.venkateshwaran.major_project

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PopularRetrofitInstance {
    val api : PopularApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PopularApi::class.java)
    }
}