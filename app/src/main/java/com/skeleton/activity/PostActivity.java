package com.skeleton.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.skeleton.R;
import com.skeleton.adapter.PostAdapter;

import com.skeleton.model.Posts;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * created by Rishab
 */
public class PostActivity extends AppCompatActivity {
    private int mId;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        final Bundle bundle = getIntent().getBundleExtra("id");
        UserInfo obj = bundle.getParcelable("obj");
        mId = obj.getId();

        RestClient.getApiInterface().getPosts(mId).enqueue(new ResponseResolver<List<Posts>>(this, true) {
            @Override
            public void success(final List<Posts> posts) {

                Log.d("abc", String.valueOf(mId));
                PostAdapter recyclerViewAdapter = new PostAdapter(posts, PostActivity.this, mId);

                recyclerView = (RecyclerView) findViewById(R.id.rv_posts);
                recyclerView.setLayoutManager(new LinearLayoutManager(PostActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);


            }

            @Override
            public void failure(final APIError error) {

            }
        });

    }
}
