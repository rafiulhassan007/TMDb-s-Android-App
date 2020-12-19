package com.grameenphone.digitalninja.data.repository

import com.grameenphone.digitalninja.data.model.popularmovies.PopularMovies
import com.grameenphone.digitalninja.data.model.populartvseries.PopularTvSeries
import com.grameenphone.digitalninja.data.model.trendingcontent.TrendingContent
import com.grameenphone.digitalninja.data.network.RetrofitBuilder

object AppRepo {

    suspend fun getPopularMovies(): PopularMovies = RetrofitBuilder.appApi.popularMovies()
    suspend fun getPopularTvSeries(): PopularTvSeries = RetrofitBuilder.appApi.popularTv()
    suspend fun getTrendingContent(): TrendingContent = RetrofitBuilder.appApi.trendingContent()

}