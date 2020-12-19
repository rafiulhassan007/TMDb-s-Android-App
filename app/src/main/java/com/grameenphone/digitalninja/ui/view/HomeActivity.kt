package com.grameenphone.digitalninja.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.grameenphone.digitalninja.R
import com.grameenphone.digitalninja.data.model.popularmovies.Result
import com.grameenphone.digitalninja.data.network.Status
import com.grameenphone.digitalninja.ui.adapters.PopularMoviesAdapter
import com.grameenphone.digitalninja.ui.adapters.PopularTvAdapter
import com.grameenphone.digitalninja.ui.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var appViewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        appViewModel = ViewModelProvider(this)[AppViewModel::class.java]
        setUpActionBar()
        loadPopularMovies()
        loadPopularTvShows()
    }

    private fun loadPopularMovies() {
        appViewModel.getPopularMovies().observe(
            this,
            Observer { requestResponse ->

                when (requestResponse.status) {
                    Status.LOADING -> {
                        Log.d("Tag=======", "loading")
                    }
                    Status.FAILED -> {
                        Log.d("Tag=======", "failed")
                    }
                    Status.SUCCESS -> {
                        requestResponse.data?.results.let {
                            val popularMoviesAdapter =
                                PopularMoviesAdapter()
                            popularMoviesAdapter.submitList(it)

                            popularMoviesAdapter.onItemClickListener(object :
                                PopularMoviesAdapter.OnItemClickListener {
                                override fun onItemClick(position: Int, result: Result) {
                                    Log.d("==========", "onItemClick: "+position)
                                    Toast.makeText(applicationContext,"pressed"+result.id,Toast.LENGTH_SHORT).show()
                                }
                            })

                            rv_pm.apply {
                                this.hasFixedSize()
                                this.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                                this.adapter = popularMoviesAdapter
                            }
                        }
                    }
                    else -> {
                        Log.d("Tag", "loadCourseInfoData: error")
                    }
                }
            })
    }

    private fun loadPopularTvShows() {
        appViewModel.getPopularTv().observe(
            this,
            Observer { requestResponse ->

                when (requestResponse.status) {
                    Status.LOADING -> {
                        Log.d("Tag=======", "loading")
                    }
                    Status.FAILED -> {
                        Log.d("Tag=======", "failed")
                    }
                    Status.SUCCESS -> {
                        requestResponse.data?.results.let {
                            val popularTvAdapter =
                                PopularTvAdapter()
                            popularTvAdapter.submitList(it)

                            popularTvAdapter.onItemClickListener(object :
                                PopularTvAdapter.OnItemClickListener {
                                override fun onItemClick(position: Int, result: com.grameenphone.digitalninja.data.model.populartvseries.Result) {
                                    Log.d("==========", "onItemClick: "+position)
                                    Toast.makeText(applicationContext,"pressed"+result.id,Toast.LENGTH_SHORT).show()
                                }
                            })

                            rv_pts.apply {
                                this.hasFixedSize()
                                this.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                                this.adapter = popularTvAdapter
                            }
                        }
                    }
                    else -> {
                        Log.d("Tag", "loadCourseInfoData: error")
                    }
                }
            })
    }

    private fun setUpActionBar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar)
    }
}