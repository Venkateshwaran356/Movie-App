package com.venkateshwaran.major_project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()
    fun getPopularMovies() {
        PopularRetrofitInstance.api.getPopularMovies("8a5dd87651f90fd9e9f9c9a9df34472c").enqueue(object  : Callback<PopularApiKey> {
            override fun onResponse(call: Call<PopularApiKey>, response: Response<PopularApiKey>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<PopularApiKey>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}