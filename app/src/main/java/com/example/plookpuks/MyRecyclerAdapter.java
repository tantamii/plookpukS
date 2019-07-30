package com.example.plookpuks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class MyRecyclerAdapter extends
        RecyclerView.Adapter<MyRecyclerAdapter.Holder>{

    class Holder extends RecyclerView.ViewHolder{

        public TextView textTitle;
        public TextView textDescription;
        private String[] mDataSet;
        String[] strings = {"A","B","C"};
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(strings);
        recyclerView.setAdapter(adapter);



        public Holder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);        }
        public void setItem(int position){
            textTitle.setText(mDataSet[position]);
            textDescription.setText("index = " + position);
        }


    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
    public MyRecyclerAdapter(String[] dataSet){
        mDataSet = dataSet;
    }


}
