package com.venkateshwaran.major_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.venkateshwaran.major_project.databinding.ActivityLatestsBinding
import com.venkateshwaran.major_project.databinding.ActivityPopularBinding
import com.venkateshwaran.major_project.databinding.ActivityUpcomingBinding


class Latests : AppCompatActivity() {
    private lateinit var binding : ActivityLatestsBinding
    private lateinit var viewModel: LatestViewModel
    private lateinit var movieAdapter : LatestAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatestsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[LatestViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }
    private fun prepareRecyclerView() {
        movieAdapter = LatestAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}