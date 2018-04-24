package com.jiyun.asmodeus.panda.view.adapter.history;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.GreenDaoBean;

import java.util.ArrayList;


public class HistoryListAdapter extends BaseAdapter {
    Context context;
    ArrayList<GreenDaoBean> arrayList;

    public HistoryListAdapter(Context context, ArrayList<GreenDaoBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.history_fill_list, null);
            holder.fill_History_image = (ImageView) convertView.findViewById(R.id.fill_History_image);
            holder.fill_History_title = (TextView) convertView
                    .findViewById(R.id.fill_History_title);
            holder.fill_History_content = (TextView) convertView.findViewById(R.id.fill_History_content);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(arrayList.get(position).getImageurl()).into(holder.fill_History_image);
        holder.fill_History_title.setText(arrayList.get(position).getTitle());

        return convertView;
    }

    class ViewHolder {
        ImageView fill_History_image;
        TextView fill_History_title;
        TextView fill_History_content;
    }

}
