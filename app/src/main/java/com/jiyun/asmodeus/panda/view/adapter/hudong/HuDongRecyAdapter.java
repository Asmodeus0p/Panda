package com.jiyun.asmodeus.panda.view.adapter.hudong;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.HuDong;

import java.util.ArrayList;


public class HuDongRecyAdapter extends RecyclerView.Adapter<HuDongRecyAdapter.Holder> implements View.OnClickListener {

    private ArrayList<HuDong.InteractiveBean> mList;
    private Context context;
    public HuDongRecyAdapter(ArrayList<HuDong.InteractiveBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hudongfillrecy, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mText.setText(mList.get(position).getTitle());
        Glide.with(context).load(mList.get(position).getImage()).into(holder.hudong_fill_image);
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView hudong_fill_image;
        public Holder(View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.hudong_fill_text);
            hudong_fill_image = itemView.findViewById(R.id.hudong_fill_image);
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