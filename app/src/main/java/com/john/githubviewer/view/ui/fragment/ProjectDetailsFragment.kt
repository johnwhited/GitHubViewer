package com.john.githubviewer.view.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.john.githubviewer.R
import com.john.githubviewer.databinding.FragmentProjectDetailsBinding
import com.john.githubviewer.factory.ViewModelFactory
import com.john.githubviewer.model.Resource
import com.john.githubviewer.model.TrendingProject
import com.john.githubviewer.viewmodel.ProjectDetailsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_project_details.*
import org.jetbrains.anko.okButton
import org.jetbrains.anko.support.v4.alert
import javax.inject.Inject

class ProjectDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(ProjectDetailsViewModel::class.java) }

    private lateinit var binding: FragmentProjectDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        val trendingProject = arguments?.getParcelable<TrendingProject>(KEY_TRENDING_PROJECT)

        val c = context
        if (trendingProject != null && c != null) {
            showLoadingSpinner()
            viewModel.getProjectsDetails(trendingProject, c).observe(this, Observer {
                it?.let {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            hideLoadingSpinner()
                            binding.project = it.data
                        }

                        Resource.Status.ERROR -> {
                            if (it.message != null) {
                                alert(getString(R.string.fragment_network_error_message, it.message)) {
                                    okButton {
                                        observeViewModel()
                                    }

                                    onCancelled {
                                        this@ProjectDetailsFragment.activity?.onBackPressed()
                                    }
                                }.show()
                            }
                        }
                    }
                }
            })
        }
    }

    private fun showLoadingSpinner() {
        pb_load_spinner.visibility = View.VISIBLE
        sv_details.visibility = View.GONE
    }

    private fun hideLoadingSpinner() {
        pb_load_spinner.visibility = View.GONE
        sv_details.visibility = View.VISIBLE
    }

    companion object Factory {
        private const val KEY_TRENDING_PROJECT = "KEY_TRENDING_PROJECT"

        fun newInstance(trendingProject: TrendingProject): ProjectDetailsFragment {
            val pdf = ProjectDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_TRENDING_PROJECT, trendingProject)
            pdf.arguments = bundle
            return pdf
        }
    }
}
