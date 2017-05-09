package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.Posts;


import java.util.List;



/**
 * Created by Rishab on 08-05-2017.
 */

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Posts> posts;
    private Context mContext;
    private int mID;

    /**
     *
     * @param posts posts list
     * @param mContext context of activity
     * @param mID id
     */
    public PostAdapter(final List<Posts> posts, final Context mContext, final int mID) {
        this.posts = posts;
        this.mContext = mContext;
        this.mID = mID;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView;
        itemView = LayoutInflater.from(mContext).inflate(R.layout.post_items, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Posts currentUser = posts.get(position);
        if (mID == currentUser.getUserId()) {
            viewHolder.mId.setText(String.valueOf(currentUser.getId()));
            viewHolder.mTitle.setText(currentUser.getTitle());
            viewHolder.mDescribe.setText(currentUser.getBody());
        }


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    /**
     * abc
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mId;
        private TextView mDescribe;

        /**
         *
         * @param itemView itemview
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            mDescribe = (TextView) itemView.findViewById(R.id.user_describe);
            mId = (TextView) itemView.findViewById(R.id.user_id);
            mTitle = (TextView) itemView.findViewById(R.id.user_title);

        }
    }
}
