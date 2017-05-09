package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.PostActivity;
import com.skeleton.model.UserInfo;

/**
 * Created by Rishab on 08-05-2017.
 */

public class BelowFragment extends Fragment {

    private TextView mId;
    private TextView mName;
    private Button buttonpost;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_below, container, false);
        init(rootView);

        final Bundle bundle = getArguments();
        UserInfo obj = bundle.getParcelable("obj");
        mId.setText(String.valueOf(obj.getId()));
        mName.setText(obj.getName());

        buttonpost = (Button) rootView.findViewById(R.id.btn_posts);
        buttonpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                intent = new Intent(getContext(), PostActivity.class);
                intent.putExtra("id", bundle);
                startActivity(intent);
            }

        });
        return rootView;

    }

    /**
     *
     * @param view view
     */

    private void init(final View view) {
        mId = (TextView) view.findViewById(R.id.user_id);
        mName = (TextView) view.findViewById(R.id.user_name);
    }


}
