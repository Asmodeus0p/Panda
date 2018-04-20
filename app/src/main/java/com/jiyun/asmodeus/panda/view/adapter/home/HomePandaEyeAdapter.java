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
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;

import java.util.ArrayList;

public class HomePandaEyeAdapter extends RecyclerView.Adapter<HomePandaEyeAdapter.Holder> implements View.OnClickListener {

    private ArrayList<HomePandaEye.ListBean> mList;

    public HomePandaEyeAdapter(ArrayList<HomePandaEye.ListBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fill_pandaeyerect, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Glide.with(App.context).load(mList.get(position).getImage()).into(holder.home_pandaeye_item_img);
        holder.home_pandaeye_item_title.setText(mList.get(position).getTitle());
        holder.home_pandaeye_item_time.setText(mList.get(position).getDaytime());
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private ImageView home_pandaeye_item_img;
        private TextView home_pandaeye_item_title;
        private TextView home_pandaeye_item_time;

        public Holder(View itemView) {
            super(itemView);
            home_pandaeye_item_img = itemView.findViewById(R.id.home_pandaeye_item_img);
            home_pandaeye_item_title = itemView.findViewById(R.id.home_pandaeye_item_title);
            home_pandaeye_item_time = itemView.findViewById(R.id.home_pandaeye_item_time);
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
