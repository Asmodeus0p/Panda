package com.jiyun.asmodeus.panda.view.adapter.userfeedback;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.R;

import java.util.ArrayList;


public class CommonListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> titles;
    ArrayList<String> content;

    public CommonListViewAdapter(Context context, ArrayList<String> titles, ArrayList<String> content) {
        this.context = context;
        this.titles = titles;
        this.content = content;


    }

    @Override
    public int getCount() {
        return titles.size();
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
                    R.layout.activity_personal_feedback_commonquestion_item, null);
            holder.commonquestion_item_title = (TextView) convertView.findViewById(R.id.commonquestion_item_title);
            holder.commonquestion_item_content = (TextView) convertView
                    .findViewById(R.id.commonquestion_item_content);

            convertView.setTag(holder);
            Log.e("getView", "create holder");
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.commonquestion_item_title.setText(titles.get(position));
        holder.commonquestion_item_content.setText(content.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView commonquestion_item_title;
        TextView commonquestion_item_content;

    }

}
