package com.example.testme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class relative_layout extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<SpinnerItem> mSpinnerList;
    private SpinnerAdapter mSpinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        initList();

        Spinner spinner = findViewById(R.id.spinner_home);
        mSpinnerAdapter = new SpinnerAdapter(this,mSpinnerList);
        spinner.setAdapter(mSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clickedItem = (SpinnerItem) adapterView.getItemAtPosition(i);
                String clicked = clickedItem.getApp_name();
                Toast.makeText(relative_layout.this,clicked+" selected",Toast.LENGTH_SHORT).show();

                ArrayList<ExampleItem> examplelist = new ArrayList<>();
                String arr[] = {"Okayy","Byee","Welcome"};
                String arr1[] = {"hello","222","111"};
                String arr2[] = {"aaa","ddd","bbb"};
                for(int j=0 ; j< arr.length ; j++)
                {
                    if(arr[j].equals(clicked))
                    {
                        examplelist.add(new ExampleItem(arr1[j],arr2[j]));
                    }
                }

                mRecyclerView = findViewById(R.id.recyclerView);
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(relative_layout.this);
                mAdapter = new ExampleAdapter(examplelist);

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initList()
    {
        mSpinnerList = new ArrayList<>();
        mSpinnerList.add(new SpinnerItem("Okayy"));
        mSpinnerList.add(new SpinnerItem("Byee"));
        mSpinnerList.add(new SpinnerItem("Welcome"));
    }
}