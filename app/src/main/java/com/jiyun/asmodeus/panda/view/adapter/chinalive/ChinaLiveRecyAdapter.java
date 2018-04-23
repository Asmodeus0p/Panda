package com.jiyun.asmodeus.panda.view.adapter.chinalive;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.entity.ChinaLivefu;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;


public class ChinaLiveRecyAdapter extends RecyclerView.Adapter<ChinaLiveRecyAdapter.Holder> implements View.OnClickListener {

    private ArrayList<ChinaLivefu.LiveBean> mList;
    Context context;
    public ChinaLiveRecyAdapter(ArrayList<ChinaLivefu.LiveBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chinalive_fillrecy, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.chinalive_fill_jianjietext.setText(mList.get(position).getBrief());
        holder.chinalive_fill_liveText.setText(mList.get(position).getTitle());
//        Glide.with(context).load(mList.get(position).getImage()).into(holder.chinalive_fill_image);
        Picasso.with(context).load(mList.get(position).getImage()).into(holder.chinalive_fill_image);
//        Uri uri = Uri.parse(mList.get(position).getImage());
//        holder.chinalive_fill_image.setImageURI(uri);
        holder.chinalive_fill_imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.chinalive_fill_jianjietext.getVisibility() == View.GONE) {
                    holder.chinalive_fill_jianjietext.setVisibility(View.VISIBLE);

                    holder.chinalive_fill_imagebtn.setImageResource(R.mipmap.com_facebook_tooltip_blue_bottomnub);
                    holder.chinalive_fill_imagebtn.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    holder.chinalive_fill_jianjietext.setVisibility(View.GONE);
                    holder.chinalive_fill_imagebtn.setImageResource(R.mipmap.com_facebook_tooltip_blue_topnub);
                }
            }
        });
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private ImageView chinalive_fill_image;
        private ImageView chinalive_fill_imagebtn;
        private TextView chinalive_fill_jianjietext;
        private TextView chinalive_fill_liveText;

        public Holder(View itemView) {
            super(itemView);
            chinalive_fill_image = itemView.findViewById(R.id.chinalive_fill_image);
            chinalive_fill_imagebtn = itemView.findViewById(R.id.chinalive_fill_imagebtn);
            chinalive_fill_jianjietext = itemView.findViewById(R.id.chinalive_fill_jianjietext);
            chinalive_fill_liveText = itemView.findViewById(R.id.chinalive_fill_liveText);
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