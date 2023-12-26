package com.venkateshwaran.major_project

import com.venkateshwaran.major_project.Latest.LatestApiKey
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LatestApi {
    @GET("latest?")
    fun getLatestMovies(@Query("api_key") api_key : String) : Call<LatestApiKey>
}