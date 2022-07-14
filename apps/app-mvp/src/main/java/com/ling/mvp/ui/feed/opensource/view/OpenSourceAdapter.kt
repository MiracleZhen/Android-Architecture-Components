package com.ling.mvp.ui.feed.opensource.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.ling.mvp.R
import com.ling.mvp.data.network.model.OpenSource
import com.ling.mvp.utils.extension.loadImage

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceAdapter
 */
class OpenSourceAdapter(openSourceListItems: MutableList<OpenSource>) : RecyclerView.Adapter<OpenSourceAdapter.OpenSourceViewHolder>() {

    private val openSourceListItems: MutableList<OpenSource> = openSourceListItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenSourceViewHolder {
        return OpenSourceViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_open_source_list, parent, false))
    }

    override fun onBindViewHolder(holder: OpenSourceViewHolder, position: Int) = holder.run {
        clear()
        onBind(position)
    }

    override fun getItemCount() = openSourceListItems.size

    internal fun addOpenSourcesToList(OpenSources: List<OpenSource>) {
        this.openSourceListItems.addAll(OpenSources)
        notifyDataSetChanged()
    }

    inner class OpenSourceViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var ivCover: ImageView = view.findViewById(R.id.coverImageView)
        private var tvTitle: TextView = view.findViewById(R.id.titleTextView)
        private var tvDesc: TextView = view.findViewById(R.id.contentTextView)

        fun onBind(position: Int) {
            val (title, description, projectUrl, coverImgUrl) = openSourceListItems[position]

            inflateData(title, description, coverImgUrl)
            setItemClickListener(projectUrl)
        }

        fun clear() {
            ivCover.setImageDrawable(null)
            tvTitle.text = ""
            tvDesc.text = ""
        }

        private fun inflateData(title: String?, description: String?, coverImgUrl: String?) {
            title?.let { tvTitle.text = it }
            description?.let { tvDesc.text = it }
            coverImgUrl?.let {
                ivCover.loadImage(it)
            }
        }

        private fun setItemClickListener(projectUrl: String?) {
            itemView.setOnClickListener {
                projectUrl?.let {
                    try {
                        // using "apply" as an example
                        itemView.context.startActivity(Intent().apply {
                            action = Intent.ACTION_VIEW
                            data = it.toUri()
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        })
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}
