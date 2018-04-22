package com.jiyun.asmodeus.panda.view.adapter.cctv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;

import java.util.ArrayList;


public class CCTV_YangShi_Adapter extends RecyclerView.Adapter<CCTV_YangShi_Adapter.Holder> implements View.OnClickListener {

    private ArrayList<CCTVYangShi.ListBean> mList;
    Context context;
    public CCTV_YangShi_Adapter(ArrayList<CCTVYangShi.ListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cctv_fillrecy, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.fill_CCTV_title.setText(mList.get(position).getTitle());
        holder.fill_CCTV_content.setText(mList.get(position).getBrief());
        Glide.with(context).load(mList.get(position).getImage()).into(holder.fill_CCTV_image);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView fill_CCTV_title;
        private ImageView fill_CCTV_image;
        private TextView fill_CCTV_content;
        public Holder(View itemView) {
            super(itemView);
            fill_CCTV_title = itemView.findViewById(R.id.fill_CCTV_title);
            fill_CCTV_image = itemView.findViewById(R.id.fill_CCTV_image);
            fill_CCTV_content = itemView.findViewById(R.id.fill_CCTV_content);
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