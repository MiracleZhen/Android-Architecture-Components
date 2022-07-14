package com.ling.mvp.ui.feed.blog.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ling.mvp.R
import com.ling.mvp.data.network.model.Blog
import com.ling.mvp.utils.extension.loadImage
import java.lang.Exception

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogAdapter
 */
class BlogAdapter(private val blogListItems: MutableList<Blog>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_blog_list, parent, false))
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun getItemCount(): Int = this.blogListItems.size

    internal fun addBlogsToList(blogs: List<Blog>) {
        this.blogListItems.addAll(blogs)
        notifyDataSetChanged()
    }

    inner class BlogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var ivCover: ImageView = view.findViewById(R.id.coverImageView)
        private var tvTitle: TextView = view.findViewById(R.id.titleTextView)
        private var tvAuthor: TextView = view.findViewById(R.id.authorTextView)
        private var tvDate: TextView = view.findViewById(R.id.dateTextView)
        private var tvDesc: TextView = view.findViewById(R.id.contentTextView)

        fun clear() {
            ivCover.setImageDrawable(null)
            tvTitle.text = ""
            tvDesc.text = ""
        }

        fun onBind(position: Int) {
            val (title, description, author, date, blogUrl, coverPageUrl) = blogListItems[position]
            inflateData(title, description, author, date, coverPageUrl)
            setItemClickListener(blogUrl)
        }

        private fun inflateData(title: String?, description: String?, author: String?, date: String?, coverPageUrl: String?) {
            title?.let { tvTitle.text = it }
            author?.let { tvAuthor.text = it }
            date?.let { tvDate.text = it }
            description?.let { tvDesc.text = it }
            coverPageUrl?.let {
                ivCover.loadImage(it)
            }
        }

        private fun setItemClickListener(blogUrl: String?) {
            itemView.setOnClickListener {
                blogUrl?.let {
                    try {
                        val intent = Intent()
                        // using "with" as an example
                        with(intent) {
                            action = Intent.ACTION_VIEW
                            data = Uri.parse(it)
                            addCategory(Intent.CATEGORY_BROWSABLE)
                        }
                        itemView.context.startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}
