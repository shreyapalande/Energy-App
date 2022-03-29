package com.example.testme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class add_app extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_app);

        ArrayList<ExampleItem> examplelist = new ArrayList<>();
        String arr1[] = {"hello","222","111"};
        String arr2[] = {"aaa","ddd","bbb"};

        for(int j=0 ; j< arr1.length ; j++)
        {
            examplelist.add(new ExampleItem(arr1[j],arr2[j]));
        }

        mRecyclerView = findViewById(R.id.addView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(examplelist);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}