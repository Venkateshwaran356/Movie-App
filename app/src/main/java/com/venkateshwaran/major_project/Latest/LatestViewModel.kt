package com.venkateshwaran.major_project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.venkateshwaran.major_project.Latest.LatestApiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LatestViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        LatestRetrofitInstance.api.getLatestMovies("8a5dd87651f90fd9e9f9c9a9df34472c").enqueue(object  : Callback<LatestApiKey> {
            override fun onResponse(call: Call<LatestApiKey>, response: Response<LatestApiKey>) {
            }
            override fun onFailure(call: Call<LatestApiKey>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}