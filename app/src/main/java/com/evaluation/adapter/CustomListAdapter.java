package com.evaluation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.evaluation.command.ICommand;
import com.evaluation.model.result.Result;
import com.evaluation.userlist.R;
import com.evaluation.utils.StringUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ListAdapterHolder> {

    private final Context mContext;
    private final ArrayList<Result> mUserList;
    private final ICommand<Result> mClickCommand;


    public CustomListAdapter(Context context, ArrayList<Result> userList, ICommand<Result> mClickCommand) {
        this.mContext = context;
        this.mUserList = userList;
        this.mClickCommand = mClickCommand;
    }

    @NotNull
    @Override
    public ListAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ListAdapterHolder(mContext, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ListAdapterHolder userListAdapterHolder, int position) {
        userListAdapterHolder.bind(getItem(position), mClickCommand);
    }


    private Result getItem(int position) {
        return mUserList.get(position);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    static class ListAdapterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.gender)
        TextView titleView;

        @BindView(R.id.thumbnail)
        ImageView thumbnailView;

        private Context mContext;

        ListAdapterHolder(Context context, View view) {
            super(view);
            mContext = context;
            ButterKnife.bind(this, view);
        }

        void bind(final Result userList, ICommand<Result> clickCommand) {

            itemView.setOnClickListener(v -> clickCommand.execute(userList));

            Glide.with(mContext)
                    .load(userList.getPicture().getThumbnail())
                    .into(thumbnailView);

            String firstLastName = userList.getName().getTitle() +
                    StringUtils.DOT_STRING +
                    StringUtils.BLANK_STRING +
                    userList.getName().getFirst() +
                    StringUtils.BLANK_STRING +
                    userList.getName().getLast();
            titleView.setText(firstLastName);
        }
    }
}
