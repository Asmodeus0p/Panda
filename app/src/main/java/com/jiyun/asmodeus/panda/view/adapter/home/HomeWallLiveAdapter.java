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
import com.jiyun.asmodeus.panda.model.entity.HomeBean;

import java.util.ArrayList;

public class HomeWallLiveAdapter extends RecyclerView.Adapter<HomeWallLiveAdapter.Holder> implements View.OnClickListener {

    private ArrayList<HomeBean.DataBean.WallliveBean.ListBean> mList;

    public HomeWallLiveAdapter(ArrayList<HomeBean.DataBean.WallliveBean.ListBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fillpandalive, parent,false);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Glide.with(App.context).load(mList.get(position).getImage()).into(holder.fillPandaliveimage);
        holder.fillPandaLiveText.setText(mList.get(position).getTitle());
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private ImageView fillPandaliveimage;
        private TextView fillPandaLiveText;

        public Holder(View itemView) {
            super(itemView);
            fillPandaliveimage = itemView.findViewById(R.id.fillPandaliveimage);
            fillPandaLiveText = itemView.findViewById(R.id.fillPandaLiveText);
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
