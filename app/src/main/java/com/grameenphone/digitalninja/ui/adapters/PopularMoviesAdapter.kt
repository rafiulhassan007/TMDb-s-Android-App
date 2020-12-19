package com.grameenphone.digitalninja.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grameenphone.digitalninja.data.model.popularmovies.Result
import com.grameenphone.digitalninja.R
import com.grameenphone.digitalninja.data.network.ApiConstants
import kotlinx.android.synthetic.main.popular_movie_item.view.*

class PopularMoviesAdapter : ListAdapter<Result, PopularMoviesAdapter.ItemHolder>(DiffCallback()) {

    interface OnItemClickListener {
        fun onItemClick(position: Int, file: Result)
    }

    private var onItemClickListener: OnItemClickListener? = null
    private var result: Result? = null

    class ItemHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        val root: LinearLayout = view.root

        public fun bind(result: Result) {
            view.tv_title.text = result?.original_title
            Glide.with(view.context).load(ApiConstants.posterImagePrefix+result?.poster_path)
                .error(R.drawable.loading_img)
                .into(view.iv_poster)
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_item, parent, false)
        return ItemHolder(
            view
        )
    }

    public fun onItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
        holder.root.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                onItemClickListener?.onItemClick(position, getItem(position))
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

    }
}