package com.pedromoura.itau.presentation.pull_request

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedromoura.itau.data.model.PullRequestModel
import com.pedromoura.itau.databinding.RepositoryListPullRequestItemBinding
import com.squareup.picasso.Picasso

class PullRequestListAdapter(
    private val listPulls: List<PullRequestModel>
) : RecyclerView.Adapter<PullRequestListAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder =
        PullRequestViewHolder(
            RepositoryListPullRequestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bindView(listPulls[position])
    }

    override fun getItemCount(): Int {
        return listPulls.size
    }

    inner class PullRequestViewHolder(
        itemView: RepositoryListPullRequestItemBinding
    ) : RecyclerView.ViewHolder(itemView.root) {

        private val title = itemView.titlePull
        private val description = itemView.descriptionPull
        private val login = itemView.userName
        private val photo = itemView.imgUser

        fun bindView(pull: PullRequestModel) {
            title.text = pull.title
            description.text = pull.body
            login.text = pull.user.login

            Picasso.get()
                .load(pull.user.avatar_url)
                .into(photo)
        }
    }
}