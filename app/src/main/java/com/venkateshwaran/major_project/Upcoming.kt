package com.venkateshwaran.major_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.venkateshwaran.major_project.databinding.ActivityPopularBinding
import com.venkateshwaran.major_project.databinding.ActivityUpcomingBinding


class Upcoming : AppCompatActivity() {
    private lateinit var binding : ActivityUpcomingBinding
    private lateinit var viewModel: UpcomingViewModel
    private lateinit var movieAdapter : UpcomingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpcomingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[UpcomingViewModel::class.java]
        viewModel.getUpcomingMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }
    private fun prepareRecyclerView() {
        movieAdapter = UpcomingAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}