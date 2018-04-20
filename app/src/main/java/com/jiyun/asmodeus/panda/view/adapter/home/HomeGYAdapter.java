package com.jiyun.asmodeus.panda.view.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.GYChina;

import java.util.ArrayList;


public class HomeGYAdapter extends RecyclerView.Adapter<HomeGYAdapter.Holder> implements View.OnClickListener {

    private ArrayList<GYChina.ListBean> mList;

    public HomeGYAdapter( ArrayList<GYChina.ListBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fill_gy, parent,false);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.home_fillGYText.setText(mList.get(position).getTitle());
        holder.home_fillGYtime.setText(mList.get(position).getDaytime());
        Glide.with(App.context).load(mList.get(position).getImage()).into(holder.home_fillGYimage);
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView home_fillGYText;
        private TextView home_fillGYtime;
        private ImageView home_fillGYimage;

        public Holder(View itemView) {
            super(itemView);
            home_fillGYText = itemView.findViewById(R.id.home_fillGYText);
            home_fillGYtime = itemView.findViewById(R.id.home_fillGYtime);
            home_fillGYimage = itemView.findViewById(R.id.home_fillGYimage);
        }
    }

    public interface OnItemClick {
        void setOnItemClick(View v, int position);
    }

    private OnItemClick mOnItem;

    @Override
    public void onClick(View v) {
        if (mOnItem != null) {
            mOnItem.setOnItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItem(OnItemClick onItem) {
        this.mOnItem = onItem;
    }

}