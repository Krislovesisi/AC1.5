package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private static final String TAG = "ItemAdapter";

    private Context mContext;

    private List<Home_Item> mHomeItemList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            itemImage = (ImageView) view.findViewById(R.id.item_image);
            itemName = (TextView) view.findViewById(R.id.item_name);
        }
    }

    public ItemAdapter(List<Home_Item> homeItemList) {
        mHomeItemList = homeItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Home_Item homeItem = mHomeItemList.get(position);
                Intent intent = new Intent(mContext, ItemActivity.class);
                intent.putExtra(ItemActivity.ITEM_NAME, homeItem.getName());
                intent.putExtra(ItemActivity.ITEM_IMAGE_ID, homeItem.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Home_Item homeItem = mHomeItemList.get(position);
        holder.itemName.setText(homeItem.getName());
        Glide.with(mContext).load(homeItem.getImageId()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return mHomeItemList.size();
    }

}
