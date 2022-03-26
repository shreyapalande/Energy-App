package com.example.testme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    PieChart pieChart;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<SpinnerItem> mSpinnerList;
    private SpinnerAdapter mSpinnerAdapter;

    int arr1[] = {25,30,22,35};
    String arr2[] = {"first","second","third","fourth"};
    int arr3[] = {Color.parseColor("#FFA726"),Color.parseColor("#66BB6A"),Color.parseColor("#EF5350"),Color.parseColor("#29B6F6")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        pieChart = findViewById(R.id.piechart);

        setData();
        initList();

        Spinner spinner = findViewById(R.id.spinner_spinner);
        mSpinnerAdapter = new SpinnerAdapter(this,mSpinnerList);
        spinner.setAdapter(mSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clickedItem = (SpinnerItem) adapterView.getItemAtPosition(i);
                String clicked = clickedItem.getApp_name();
                Toast.makeText(home.this,clicked+" selected",Toast.LENGTH_SHORT).show();

                ArrayList<ExampleItem> examplelist = new ArrayList<>();
                String arr[] = {"Okayy","Byee","Welcome"};
                for(int j=0 ; j< arr.length ; j++)
                {
                    if(arr[j].equals(clicked))
                    {
                        examplelist.add(new ExampleItem(Integer.toString(arr1[j]),arr2[j]));
                    }
                }

                mRecyclerView = findViewById(R.id.homeView);
                mRecyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(home.this);
                mAdapter = new ExampleAdapter(examplelist);

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        ArrayList<ExampleItem> examplelist = new ArrayList<>();
//
//        for(int i=0 ; i<arr2.length ; i++)
//            examplelist.add(new ExampleItem(arr2[i],Integer.toString(arr1[i])));
//
//        mRecyclerView = findViewById(R.id.homeView);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mAdapter = new ExampleAdapter(examplelist);
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

//        listView = (ListView) findViewById(R.id.listView);
//        ArrayList <String> arrayList = new ArrayList<>();
//
//        for(int i=0 ; i<arr2.length ; i++)
//            arrayList.add(arr2[i]);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);


    }

    private void setData(){
        // Set the percentage of language used
        for(int i=0 ; i<arr1.length ; i++)
        {
            pieChart.addPieSlice(new PieModel(arr2[i],arr1[i],arr3[i]));
        }

        // To animate the pie chart
        pieChart.startAnimation();

    }

    private void initList()
    {
        mSpinnerList = new ArrayList<>();
        mSpinnerList.add(new SpinnerItem("Okayy"));
        mSpinnerList.add(new SpinnerItem("Byee"));
        mSpinnerList.add(new SpinnerItem("Welcome"));
    }
}