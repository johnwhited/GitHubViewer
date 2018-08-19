package com.john.githubviewer.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.john.githubviewer.R
import com.john.githubviewer.databinding.ItemTrendingProjectBinding
import com.john.githubviewer.model.TrendingProject
import org.jetbrains.anko.layoutInflater

class TrendingProjectAdapter(val trendingProjects: List<TrendingProject>) : RecyclerView.Adapter<TrendingProjectAdapter.TrendingProjectViewHolder>() {

    class TrendingProjectViewHolder(private val binding: ItemTrendingProjectBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindProject(project: TrendingProject) {
            binding.project = project
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingProjectViewHolder {
        val binding: ItemTrendingProjectBinding =
                DataBindingUtil.inflate(parent.context.layoutInflater, R.layout.item_trending_project, parent,false)
        return TrendingProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingProjectViewHolder, position: Int) {
        holder.bindProject(trendingProjects[position])
    }

    override fun getItemCount(): Int {
        return trendingProjects.size
    }

    fun getItem(position: Int): TrendingProject {
        return trendingProjects[position]
    }
}
