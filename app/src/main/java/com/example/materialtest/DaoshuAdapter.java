package com.example.materialtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class DaoshuAdapter extends RecyclerView.Adapter <DaoshuAdapter.ViewHolder>{

    private List<Daoshu> DaoshuList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View daoshuView;
        ImageView daoshuImage;
        TextView daoshuName;

        public ViewHolder(View view) {
            super(view);
            daoshuView = view;
            daoshuImage = (ImageView) view.findViewById(R.id.daoshu_image);
            daoshuName = (TextView) view.findViewById(R.id.daoshu_name);
        }
    }

    public DaoshuAdapter(List<Daoshu> daoshuList) {
        DaoshuList = daoshuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daoshu_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.daoshuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Daoshu daoshu = DaoshuList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + daoshu.getDaoshuname(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.daoshuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Daoshu fruit = DaoshuList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getDaoshuname(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Daoshu daoshu = DaoshuList.get(position);
        holder.daoshuImage.setImageResource(daoshu.getDaoshuimageId());
        holder.daoshuName.setText(daoshu.getDaoshuname());
    }

    @Override
    public int getItemCount() {
        return DaoshuList.size();
    }

}
