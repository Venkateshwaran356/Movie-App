package com.venkateshwaran.major_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.venkateshwaran.major_project.databinding.PopularLayoutBinding

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private var movieList = ArrayList<Result>()
    fun setMovieList(movieList: List<Result>) {
        this.movieList =
            movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: PopularLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PopularLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://api.themoviedb.org/3/movie/" + movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].original_title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}