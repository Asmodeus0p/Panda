package com.jiyun.asmodeus.panda.view.adapter.pandaeye;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;

import java.util.ArrayList;



public class PandaEyeAdapter extends BaseAdapter {
    Context context;
    ArrayList<PandaEyeBean.ListBean> mlist;

    public PandaEyeAdapter(Context context, ArrayList<PandaEyeBean.ListBean> arrayList) {
        this.context = context;
        this.mlist = arrayList;
    }

    @Override
    public int getCount() {
        return mlist.size();
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
                    R.layout.pandaeye_fillrecy, null);
            holder.paandaeye_fill_recyImage = convertView.findViewById(R.id.paandaeye_fill_recyImage);
            holder.paandaeye_fill_recytime = convertView.findViewById(R.id.paandaeye_fill_recytime);
            holder. paandaeye_fill_recytitle = convertView.findViewById(R.id.paandaeye_fill_recytitle);

            convertView.setTag(holder);
            Log.e("getView","create holder");
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.paandaeye_fill_recytime.setText(mlist.get(position).getVideolength());
        holder.paandaeye_fill_recytitle.setText(mlist.get(position).getTitle());
        Glide.with(App.context).load(mlist.get(position).getPicurl()).into(holder.paandaeye_fill_recyImage);
        return convertView;
    }

    class ViewHolder {
        private TextView paandaeye_fill_recytime;
        private TextView paandaeye_fill_recytitle;
        private ImageView paandaeye_fill_recyImage;
    }

}
