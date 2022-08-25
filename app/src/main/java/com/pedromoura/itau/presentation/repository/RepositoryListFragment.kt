package com.pedromoura.itau.presentation.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.pedromoura.itau.databinding.FragmentRepositoryListBinding
import androidx.navigation.fragment.findNavController
import com.pedromoura.itau.R
import com.pedromoura.itau.data.model.RepositoryModel

class RepositoryListFragment : Fragment() {

    var mListRecyclerView: RecyclerView? = null
    private var binding: FragmentRepositoryListBinding? = null
    private val viewModel: RepositoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoryListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setObservables()
    }

    private fun setUpView() {
        mListRecyclerView = binding?.recyclerView
        binding?.progressBar?.visibility = View.VISIBLE

        val layoutManager = LinearLayoutManager(context)
        mListRecyclerView?.layoutManager = layoutManager
    }

    private fun setObservables() {
        viewModel.getRepositories().observe(requireActivity()) { state ->
            state?.let { repositories ->
                binding?.progressBar?.visibility = View.GONE
                mListRecyclerView?.adapter = RepositoryListAdapter(repositories, this::onClickListItem)
            }
        }
    }

    private fun onClickListItem(repository: RepositoryModel) {
        val bundle = Bundle()
        bundle.putParcelable("repository", repository)

        findNavController().navigate(R.id.PullRequestsFragment, bundle)
    }
}
