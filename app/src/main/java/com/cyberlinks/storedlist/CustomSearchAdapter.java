package com.cyberlinks.storedlist;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amin on 04-Oct-16.
 */
public class CustomSearchAdapter extends RecyclerView.Adapter<CustomSearchAdapter.ViewHolder>{
    List<Pojo> poojabean;
    Context context;


    public CustomSearchAdapter(Context context, List<Pojo> poojabean) {
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
