package com.cyberlinks.storedlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin on 04-Oct-16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    List<Pojo> poojabean;
    Context context;


    public CustomAdapter(Context context, List<Pojo> poojabean) {
        this.context=context;
        this.poojabean=poojabean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(itemView,context,poojabean);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pojo pooja=poojabean.get(position);
        holder.mText.setText(pooja.getName());

    }


    @Override
    public int getItemCount() {

        return poojabean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mText;


        //        Context context;
        public ViewHolder(View itemView, Context context, List<Pojo> myList) {
            super(itemView);

            mText=(TextView)itemView.findViewById(R.id.tv_name);



        }

    }

}
