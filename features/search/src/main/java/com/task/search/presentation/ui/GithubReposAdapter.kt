package com.task.search.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.task.common.loadImage
import com.task.model.GithubRepo
import com.task.search.R
import com.task.search.databinding.RepoItemBinding

class GithubReposAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GithubRepo>() {

        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return newItem.id == oldItem.id
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RepoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GithubRepoVH(
            binding,
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GithubRepoVH -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<GithubRepo>) {
        differ.submitList(list)
    }

    class GithubRepoVH
    constructor(
        private val binding: RepoItemBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GithubRepo) = with(binding) {
            nameTv.text = item.name
            descriptionTv.text = item.description
            avatarImg.loadImage(item.avatarUrl,R.drawable.github_placeholder)
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: GithubRepo)
    }
}
