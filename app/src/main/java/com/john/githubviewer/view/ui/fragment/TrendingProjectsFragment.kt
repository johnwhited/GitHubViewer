package com.john.githubviewer.view.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.john.githubviewer.R
import com.john.githubviewer.common.ui.ItemClickSupport
import com.john.githubviewer.factory.ViewModelFactory
import com.john.githubviewer.model.Resource
import com.john.githubviewer.model.TrendingProject
import com.john.githubviewer.view.adapter.TrendingProjectAdapter
import com.john.githubviewer.viewmodel.TrendingProjectsViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trending_projects.*
import org.jetbrains.anko.okButton
import org.jetbrains.anko.support.v4.alert
import javax.inject.Inject

class TrendingProjectsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(TrendingProjectsViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_trending_projects, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)

        initializeUI()
        observeViewModel()
    }

    override fun onPause() {
        ItemClickSupport.removeFrom(rv_trending_projects)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        ItemClickSupport.addTo(rv_trending_projects).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                val tp = (recyclerView.adapter as TrendingProjectAdapter).getItem(position)
                showProjectDetails(tp)
            }
        })
    }

    private fun initializeUI() {
        rv_trending_projects.hasFixedSize()
        val initialList: ArrayList<TrendingProject> = ArrayList()
        val adapter = TrendingProjectAdapter(initialList)
        rv_trending_projects.adapter = adapter
        rv_trending_projects.layoutManager = LinearLayoutManager(context)
    }

    private fun observeViewModel() {
        val c = context
        if (c != null) {
            showLoadingSpinner()
            viewModel.getTrendingProjects(c).observe(this, Observer {
                it?.let {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            hideLoadingSpinner()
                            if (it.data != null) {
                                rv_trending_projects.adapter = TrendingProjectAdapter(it.data)
                                rv_trending_projects.adapter?.notifyDataSetChanged()
                            }
                        }

                        Resource.Status.ERROR -> {
                            if (it.message != null) {
                                alert(getString(R.string.fragment_network_error_message, it.message)) {
                                    okButton {
                                        observeViewModel()
                                    }

                                    onCancelled {
                                        this@TrendingProjectsFragment.activity?.onBackPressed()
                                    }
                                }.show()
                            }
                        }
                    }
                }
            })
        }
    }

    private fun showProjectDetails(trendingProject: TrendingProject) {
        val projectDetailsFragment = ProjectDetailsFragment.newInstance(trendingProject)
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fl_fragment_holder, projectDetailsFragment)?.addToBackStack(TrendingProjectsFragment::class.java.name)?.commit()
    }

    private fun showLoadingSpinner() {
        pb_load_spinner.visibility = View.VISIBLE
        rv_trending_projects.visibility = View.GONE
    }

    private fun hideLoadingSpinner() {
        pb_load_spinner.visibility = View.GONE
        rv_trending_projects.visibility = View.VISIBLE
    }
    companion object Factory {
        fun newInstance(): TrendingProjectsFragment {
            return TrendingProjectsFragment()
        }
    }
}
