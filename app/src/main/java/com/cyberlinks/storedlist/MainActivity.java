package com.cyberlinks.storedlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    RecyclerView mRecyclerView;
    CustomAdapter adapter;
    List<Pojo> myList=new ArrayList<>();
    SearchView searchView;
    Button mSearch;
    List<Pojo> filteredList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch=(Button)findViewById(R.id.btn_search);
        mRecyclerView=(RecyclerView) findViewById(R.id.rv_list);
        adapter=new CustomAdapter(MainActivity.this,myList);
        if(myList.size()<3){
            AddList();

        }
        else{
            int position=0;
            myList.add(position,new Pojo("Allo") );
            adapter.notifyItemInserted(position);
        }

        LinearLayoutManager ll=new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(ll);

        mRecyclerView.setAdapter(adapter);
        getSearchedItem();
     /*   mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchedActivity.class));
            }
        });*/

    }

    private void AddList() {
        Pojo pojo=new Pojo("Deepanshu");
        Pojo pojo1=new Pojo("Aakash");
        Pojo pojo2=new Pojo("Rahul");
        Pojo pojo3=new Pojo("Ashish");
        Pojo pojo4=new Pojo("Ajay");
        Pojo pojo5=new Pojo("Vikas");
        Pojo pojo6=new Pojo("Vikram");
        Pojo pojo7=new Pojo("Abhishek");
        Pojo pojo8=new Pojo("Kuldeep");
        Pojo pojo9=new Pojo("Pankaj");
        Pojo pojo10=new Pojo("Bimari");
        myList.add(pojo);
        myList.add(pojo1);
        myList.add(pojo2);
        myList.add(pojo3);
        myList.add(pojo4);
        myList.add(pojo5);
        myList.add(pojo6);
        myList.add(pojo7);
        myList.add(pojo8);
        myList.add(pojo9);
        myList.add(pojo10);
    }
    public void getSearchedItem(){
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Item Clicked ="+filteredList.get(position).getName(), Toast.LENGTH_SHORT).show();

                    }
                })
        );

    }
   /* SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextChange(String query) {
            String queries=query.toLowerCase();
            filteredList= new ArrayList<>();

            for (int i = 0; i < myList.size(); i++) {

                final String text = myList.get(i).getName().toLowerCase();
                if (text.contains(queries)) {
                    filteredList.add(myList.get(i));
                }
            }
            adapter = new CustomAdapter(MainActivity.this, filteredList);
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();  // data set changed

            return true;

        }
        public boolean onQueryTextSubmit(String query) {

                    return true;
        }
    };*/

   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(listener);
        return super.onCreateOptionsMenu(menu);
    }*/
}
