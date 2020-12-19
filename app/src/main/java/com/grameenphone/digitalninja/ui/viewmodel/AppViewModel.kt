package com.grameenphone.digitalninja.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.grameenphone.digitalninja.data.model.popularmovies.PopularMovies
import com.grameenphone.digitalninja.data.model.populartvseries.PopularTvSeries
import com.grameenphone.digitalninja.data.model.trendingcontent.TrendingContent
import com.grameenphone.digitalninja.data.network.ConnectivityResource
import com.grameenphone.digitalninja.data.repository.AppRepo
import kotlinx.coroutines.Dispatchers
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class AppViewModel : ViewModel(){
    private val repository = AppRepo

    fun getPopularMovies(): LiveData<ConnectivityResource<PopularMovies>> =
        liveData(Dispatchers.IO) {
            emit(
                ConnectivityResource.loading(null)
            ) // loading
            try {
                val data = repository.getPopularMovies()
                emit(
                    ConnectivityResource.success(data)
                ) // data
            } catch (e: Exception) {
                //Logger.getLogger(TAG).warning("Error Course Details: Course ID: $courseId")
                e.printStackTrace()
                when (e) {
                    is UnknownHostException -> {
                        emit(
                            ConnectivityResource.error(null, "Network Error!")
                        )
                    }
                    is IllegalStateException -> {
                        emit(
                            ConnectivityResource.error(null, "Permission Denied")
                        )
                    }
                    is SocketTimeoutException -> {
                        emit(
                            ConnectivityResource.error(null, "Request timeout. Try again")
                        )
                    }
                    else -> {
                        emit(
                            ConnectivityResource.error(null, "Error: ${e.localizedMessage}")
                        )
                    }
                } // error
            }
        }

    fun getPopularTv(): LiveData<ConnectivityResource<PopularTvSeries>> =
        liveData(Dispatchers.IO) {
            emit(
                ConnectivityResource.loading(null)
            ) // loading
            try {
                val data = repository.getPopularTvSeries()
                emit(
                    ConnectivityResource.success(data)
                ) // data
            } catch (e: Exception) {
                //Logger.getLogger(TAG).warning("Error Course Details: Course ID: $courseId")
                e.printStackTrace()
                when (e) {
                    is UnknownHostException -> {
                        emit(
                            ConnectivityResource.error(null, "Network Error!")
                        )
                    }
                    is IllegalStateException -> {
                        emit(
                            ConnectivityResource.error(null, "Permission Denied")
                        )
                    }
                    is SocketTimeoutException -> {
                        emit(
                            ConnectivityResource.error(null, "Request timeout. Try again")
                        )
                    }
                    else -> {
                        emit(
                            ConnectivityResource.error(null, "Error: ${e.localizedMessage}")
                        )
                    }
                } // error
            }
        }

    fun getTrendingContent(): LiveData<ConnectivityResource<TrendingContent>> =
        liveData(Dispatchers.IO) {
            emit(
                ConnectivityResource.loading(null)
            ) // loading
            try {
                val data = repository.getTrendingContent()
                emit(
                    ConnectivityResource.success(data)
                ) // data
            } catch (e: Exception) {
                //Logger.getLogger(TAG).warning("Error Course Details: Course ID: $courseId")
                e.printStackTrace()
                when (e) {
                    is UnknownHostException -> {
                        emit(
                            ConnectivityResource.error(null, "Network Error!")
                        )
                    }
                    is IllegalStateException -> {
                        emit(
                            ConnectivityResource.error(null, "Permission Denied")
                        )
                    }
                    is SocketTimeoutException -> {
                        emit(
                            ConnectivityResource.error(null, "Request timeout. Try again")
                        )
                    }
                    else -> {
                        emit(
                            ConnectivityResource.error(null, "Error: ${e.localizedMessage}")
                        )
                    }
                } // error
            }
        }

}