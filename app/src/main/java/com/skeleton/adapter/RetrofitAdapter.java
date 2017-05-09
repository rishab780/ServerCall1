package com.skeleton.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.DisplayActivity;
import com.skeleton.fragment.BelowFragment;
import com.skeleton.model.UserInfo;

import java.util.List;

import static android.R.attr.id;
import static android.R.attr.mode;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Rishab on 06-05-2017.
 */

public class RetrofitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<UserInfo> mUserInfo;
    private Context mContext;
    private int mMode;

    public RetrofitAdapter(final List<UserInfo> mUserInfo, final Context mContext) {
        this.mUserInfo = mUserInfo;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView;
        itemView = LayoutInflater.from(mContext).inflate(R.layout.itemview_frag, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserInfo currentUser = mUserInfo.get(position);

        viewHolder.mId.setText(String.valueOf(currentUser.getId()));
        viewHolder.mName.setText(currentUser.getName());

    }

    @Override
    public int getItemCount() {
        return mUserInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mId;


        public ViewHolder(final View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_username);
            mId = (TextView) itemView.findViewById(R.id.tv_userid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        BelowFragment belowFragment = new BelowFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("obj", mUserInfo.get(pos));
                        belowFragment.setArguments(bundle);
                        FragmentManager fm = ((DisplayActivity) mContext).getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.details, belowFragment);
                        ft.commit();
                    }
                }
            });


        }


    }

}

