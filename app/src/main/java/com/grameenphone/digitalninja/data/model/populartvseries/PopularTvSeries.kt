package com.grameenphone.digitalninja.data.model.populartvseries

data class PopularTvSeries(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)