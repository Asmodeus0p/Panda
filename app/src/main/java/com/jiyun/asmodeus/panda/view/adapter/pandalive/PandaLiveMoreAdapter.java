package com.jiyun.asmodeus.panda.view.adapter.pandalive;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;

import java.util.ArrayList;


public class PandaLiveMoreAdapter extends RecyclerView.Adapter<PandaLiveMoreAdapter.Holder> implements View.OnClickListener {

    private ArrayList<PandaLivBean.ListBean> mList;

    public PandaLiveMoreAdapter(ArrayList<PandaLivBean.ListBean> mList) {
        this.mList = mList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pandalive_live_fillrecy, null);
        Holder holder = new Holder(view);
        //给这个VIew注册点击事件了
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.pandaLiveLiveMorefilltext.setText(mList.get(position).getTitle());
        Glide.with(App.context).load(mList.get(position).getImage()).into(holder.pandaLiveLiveMorefillImage);
        //itemVIew 跟 View一个东西  传入标记
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private ImageView pandaLiveLiveMorefillImage;
        private TextView pandaLiveLiveMorefilltext;

        public Holder(View itemView) {
            super(itemView);
            pandaLiveLiveMorefillImage = itemView.findViewById(R.id.pandaLiveLiveMorefillImage);
            pandaLiveLiveMorefilltext = itemView.findViewById(R.id.pandaLiveLiveMorefilltext);
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