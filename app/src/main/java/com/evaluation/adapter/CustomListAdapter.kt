package com.evaluation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.evaluation.adapter.CustomListAdapter.ListAdapterHolder
import com.evaluation.command.ICommand
import com.evaluation.model.result.Result
import com.evaluation.userlist.R
import com.evaluation.utils.StringUtils
import java.util.*

class CustomListAdapter(private val mContext: Context, private val mUserList: ArrayList<Result>, private val mClickCommand: ICommand<Result>) : RecyclerView.Adapter<ListAdapterHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ListAdapterHolder =
        ListAdapterHolder(mContext, LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false))

    override fun onBindViewHolder(userListAdapterHolder: ListAdapterHolder, position: Int) {
        userListAdapterHolder.bind(getItem(position), mClickCommand)
    }

    private fun getItem(position: Int): Result {
        return mUserList[position]
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    class ListAdapterHolder(private val mContext: Context, view: View) : RecyclerView.ViewHolder(view) {

        @BindView(R.id.gender)
        lateinit var titleView: TextView

        @BindView(R.id.thumbnail)
        lateinit var thumbnailView: ImageView

        init {
            ButterKnife.bind(this, view)
        }

        fun bind(userList: Result, clickCommand: ICommand<Result>) {

            itemView.setOnClickListener { clickCommand.execute(userList) }

            Glide.with(mContext)
                .load(userList.picture.thumbnail)
                .into(thumbnailView)

            val firstLastName = userList.name.title +
                    StringUtils.DOT_STRING +
                    StringUtils.BLANK_STRING +
                    userList.name.first +
                    StringUtils.BLANK_STRING +
                    userList.name.last

            titleView.text = firstLastName
        }
    }
}