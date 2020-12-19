package com.grameenphone.digitalninja.data.model.trendingcontent

data class TrendingContent(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)