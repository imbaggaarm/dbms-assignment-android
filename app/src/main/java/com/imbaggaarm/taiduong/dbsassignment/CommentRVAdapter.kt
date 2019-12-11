package com.imbaggaarm.taiduong.dbsassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comment_rv_item.view.*
import java.util.zip.Inflater

class CommentRVAdapter(private val context: Context,
                       private val dataSource: ArrayList<CommentRVItemVM>): RecyclerView.Adapter<CommentRVAdapter.CommentViewHolder>() {


    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount() = dataSource.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(inflater.inflate(R.layout.comment_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = dataSource[position]
        holder.bindComment(comment)
    }

    class CommentViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var comment: CommentRVItemVM? = null
        private val context: Context

        init {
            v.setOnClickListener(this)
            context = v.context
        }

        override fun onClick(v: View?) {
            println("On Clicked")
        }

        fun bindComment(comment: CommentRVItemVM) {
            this.comment = comment
            view.imgVProfile.setImageResource(R.drawable.small_logo)
            view.txtVName.text = comment.ownerName
            view.txtVText.text = comment.text
            view.txtVTime.text = comment.time
        }
    }
}