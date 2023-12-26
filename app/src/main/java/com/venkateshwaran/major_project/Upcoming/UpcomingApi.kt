package com.venkateshwaran.major_project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpcomingApi {
    @GET("upcoming?")
    fun getUpcomingMovies(@Query("api_key") api_key : String) : Call<UpcomingApiKey>

}