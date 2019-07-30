package com.example.plookpuks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plookpuks.Model.Farm;

import java.util.ArrayList;


public class FarmsAdapter extends RecyclerView.Adapter<FarmsAdapter.Holder> {
    private ArrayList<Farm> farms;

    public FarmsAdapter(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return farms.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;

        public Holder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.text_title);
            textDescription = itemView.findViewById(R.id.text_description);
        }

        public void setItem(int position) {
            textTitle.setText(farms.get(position).getName());
            textDescription.setText("index = " + position);
        }
    }
}