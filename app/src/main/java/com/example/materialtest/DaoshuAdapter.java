package com.example.materialtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class DaoshuAdapter extends ArrayAdapter<Daoshu>{

    private int resourceId;

    public DaoshuAdapter(Context context, int textViewResourceId, List<Daoshu> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Daoshu daoshu = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.daoshuImage = (ImageView) view.findViewById (R.id.daoshu_image);
            viewHolder.daoshuName = (TextView) view.findViewById (R.id.daoshu_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.daoshuImage.setImageResource(daoshu.getDaoshuimageId());
        viewHolder.daoshuName.setText(daoshu.getDaoshuname());
        return view;
    }

    class ViewHolder {

        ImageView daoshuImage;

        TextView daoshuName;

    }

}
