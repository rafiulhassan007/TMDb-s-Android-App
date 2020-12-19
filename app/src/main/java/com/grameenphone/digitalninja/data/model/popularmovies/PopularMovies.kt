package com.grameenphone.digitalninja.data.model.popularmovies

data class PopularMovies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)