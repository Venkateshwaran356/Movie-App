package com.venkateshwaran.major_project

import com.venkateshwaran.popular.Upcoming.Dates

data class UpcomingApiKey(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)