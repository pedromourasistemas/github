package com.pedromoura.itau.presentation.pull_request

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedromoura.itau.databinding.FragmentPullRequestBinding
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pedromoura.itau.R
import com.pedromoura.itau.data.model.RepositoryModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PullRequestFragment : Fragment() {

    var mListRecyclerView: RecyclerView? = null
    private var binding: FragmentPullRequestBinding? = null
    private val viewModel: PullRequestViewModel by viewModel()
    var repository: RepositoryModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPullRequestBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            repository = bundle.getParcelable("repository")
        } else {
            Toast.makeText(view.context, "Bundle is null", Toast.LENGTH_LONG).show()
        }

        setUpView()
        setObservables()
    }

    private fun setUpView() {
        mListRecyclerView = binding?.recyclerView

        val creator = repository?.owner?.login
        val repository = repository?.name

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getPulls(creator.toString(), repository.toString())

        val layoutManager = LinearLayoutManager(context)
        mListRecyclerView?.layoutManager = layoutManager
    }

    private fun setObservables() {
        viewModel.pullRequestResponse.observe(requireActivity()) { state ->
            state?.let { pulls ->
                if (pulls.isNotEmpty()) {
                    binding?.progressBar?.visibility = View.GONE
                    mListRecyclerView?.adapter = PullRequestListAdapter(pulls)
                } else {
                    binding?.progressBar?.visibility = View.GONE
                    Toast.makeText(requireContext(), "Não existe Pull Requests para este repositório!", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.RepositoryListFragment)
                }
            }
        }
    }
}