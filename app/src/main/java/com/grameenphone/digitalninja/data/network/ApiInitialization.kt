package com.grameenphone.digitalninja.data.network

import com.grameenphone.digitalninja.data.model.popularmovies.PopularMovies
import com.grameenphone.digitalninja.data.model.populartvseries.PopularTvSeries
import com.grameenphone.digitalninja.data.model.trendingcontent.TrendingContent
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInitialization {

    @GET("/3/discover/movie")
    suspend fun popularMovies(
        @Query("api_key") apiKey: String = ApiConstants.api_key,
        @Query("primary_release_year") primaryReleaseYear: String = ApiConstants.primary_release_year,
        @Query("sort_by") sortBy: String = ApiConstants.sort_by
    ): PopularMovies

    @GET("/3/discover/tv")
    suspend fun popularTv(
        @Query("api_key") apiKey: String = ApiConstants.api_key,
        @Query("primary_release_year") primaryReleaseYear: String = ApiConstants.primary_release_year,
        @Query("sort_by") sortBy: String = ApiConstants.sort_by
    ): PopularTvSeries

    @GET("/3/trending/all/week")
    suspend fun trendingContent(
        @Query("api_key") apiKey: String = ApiConstants.api_key
    ): TrendingContent

}