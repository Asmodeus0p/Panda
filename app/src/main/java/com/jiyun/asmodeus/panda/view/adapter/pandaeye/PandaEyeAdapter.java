package com.jiyun.asmodeus.panda.view.adapter.pandaeye;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;

import java.util.ArrayList;


public class PandaEyeAdapter extends RecyclerView.Adapter<PandaEyeAdapter.Holder> implements View.OnClickListener {

    private ArrayList<PandaEyeBean.ListBean> mList;

    public PandaEyeAdapter(ArrayList<PandaEyeBean.ListBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pandaeye_fillrecy, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.paandaeye_fill_recytime.setText(mList.get(position).getVideolength());
        holder.paandaeye_fill_recytitle.setText(mList.get(position).getTitle());
        Glide.with(App.context).load(mList.get(position).getPicurl()).into(holder.paandaeye_fill_recyImage);
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView paandaeye_fill_recytime;
        private TextView paandaeye_fill_recytitle;
        private ImageView paandaeye_fill_recyImage;

        public Holder(View itemView) {
            super(itemView);
            paandaeye_fill_recyImage = itemView.findViewById(R.id.paandaeye_fill_recyImage);
            paandaeye_fill_recytime = itemView.findViewById(R.id.paandaeye_fill_recytime);
            paandaeye_fill_recytitle = itemView.findViewById(R.id.paandaeye_fill_recytitle);
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