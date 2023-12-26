package com.venkateshwaran.major_project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularApi {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<PopularApiKey>

}