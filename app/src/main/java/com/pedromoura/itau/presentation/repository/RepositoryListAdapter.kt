package com.pedromoura.itau.presentation.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pedromoura.itau.R
import com.pedromoura.itau.data.model.RepositoryModel
import com.pedromoura.itau.databinding.RepositoryListItemBinding
import com.squareup.picasso.Picasso

class RepositoryListAdapter(
    private val listRepository: List<RepositoryModel>,
    private  val listener: (RepositoryModel) -> Unit
) : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        RepositoryViewHolder(
            RepositoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bindView(listRepository[position], position, listener)
    }

    override fun getItemCount(): Int {
        return listRepository.size
    }

    inner class RepositoryViewHolder(
        itemView: RepositoryListItemBinding
    ) : RecyclerView.ViewHolder(itemView.root) {

        private val name = itemView.nameRepository
        private val description = itemView.descriptionRepository
        private val login = itemView.userName
        private val fullName = itemView.fullName
        private val photo = itemView.imgUser
        private val forkCount = itemView.countFork
        private val starsCount = itemView.countStar

        fun bindView(repository: RepositoryModel, position: Int, listener: (RepositoryModel) -> Unit) {
            name.text = repository.name
            description.text = repository.description
            forkCount.text = repository.forks_count.toString()
            starsCount.text = repository.stargazers_count.toString()
            login.text = repository.owner.login

            Picasso.get()
                .load(repository.owner.avatar_url)
                .into(photo)

            itemView.setOnClickListener {
                listener(repository)
            }

            description.setOnClickListener {
                listener(repository)
            }

            forkCount.setOnClickListener {
                listener(repository)
            }
        }
    }
}