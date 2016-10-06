package com.cyberlinks.storedlist;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchedActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CustomSearchAdapter adapter;
    List<Pojo> myList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched);
        mRecyclerView=(RecyclerView) findViewById(R.id.rv_search);
        LinearLayoutManager ll=new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(ll);
        SharedPreferences sPrefs= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int size=sPrefs.getInt("size",0);
        for(int j=0;j<size;j++)
        {
            myList.add(new Pojo(sPrefs.getString("val"+j,null)));
        }
        adapter=new CustomSearchAdapter(SearchedActivity.this,myList);
        mRecyclerView.setAdapter(adapter);
    }
}
