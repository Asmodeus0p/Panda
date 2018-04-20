package com.jiyun.asmodeus.panda.view.adapter.home;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
import com.jiyun.asmodeus.panda.view.adapter.home.HomeAreaRecyAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomeChinaLiveAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomePandaLiveAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomeWallLiveAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.jiyun.asmodeus.panda.model.entity.HomeBean.DataBean.*;

public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {

    //这个是标记有几个模板
    private ArrayList<Object> mlist;
    private RecyclerView.ViewHolder holder;

    public RecyAdapter(ArrayList<Object> mlist) {
        this.mlist = mlist;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        holder = null;
        View view = null;
        if (viewType % 9 == 0) {
            view = inflater.inflate(R.layout.home_recy_fill_one, parent, false);
            holder = new HolderOne(view);//多态思想
        }
        if (viewType % 9 == 1) {
            view = inflater.inflate(R.layout.home_recy_fill_two, parent, false);
            holder = new HolderTwo(view);//多态思想
        }
        if (viewType % 9 == 2) {
            view = inflater.inflate(R.layout.home_recy_fill_three, parent, false);
            holder = new HolderThree(view);//多态思想
        }
        if (viewType % 9 == 3) {
            view = inflater.inflate(R.layout.home_recy_fill_four, parent, false);
            holder = new HolderFour(view);//多态思想
        }
        if (viewType % 9 == 4) {
            view = inflater.inflate(R.layout.home_recy_fill_five, parent, false);
            holder = new HolderFive(view);//多态思想
        }
        if (viewType % 9 == 5) {
            view = inflater.inflate(R.layout.home_recy_fill_six, parent, false);
            holder = new HolderSix(view);//多态思想
        }
        if (viewType % 9 == 6) {
            view = inflater.inflate(R.layout.home_recy_fill_seven, parent, false);
            holder = new HolderSeven(view);//多态思想
        }
        if (viewType % 9 == 7) {
            view = inflater.inflate(R.layout.home_recy_fill_eight, parent, false);
            holder = new HolderEight(view);//多态思想
        }
        if (viewType % 9 == 8) {
            view = inflater.inflate(R.layout.home_recy_fill_nine, parent, false);
            holder = new HolderNine(view);//多态思想
        }


        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof HolderOne) {
            ArrayList<BigImgBean> bigImgBean = (ArrayList<BigImgBean>) mlist.get(position);
            ArrayList<String> urls = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            for (BigImgBean imgBean : bigImgBean) {
                urls.add(imgBean.getImage());
                titles.add(imgBean.getTitle());
            }
            //设置内置样式，共有六种可以点入方法内逐一体验使用。
            ((HolderOne) holder).homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器，图片加载器在下方
            ((HolderOne) holder).homeBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load((String) path).into(imageView);
                }
            });
            //设置图片网址或地址的集合
            ((HolderOne) holder).homeBanner.setImages(urls);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            ((HolderOne) holder).homeBanner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            ((HolderOne) holder).homeBanner.setBannerTitles(titles);
            //设置轮播间隔时间
            ((HolderOne) holder).homeBanner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            ((HolderOne) holder).homeBanner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            ((HolderOne) holder).homeBanner.setIndicatorGravity(BannerConfig.RIGHT)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener(this)
                    //必须最后调用的方法，启动轮播图。
                    .start();
        }
        if (holder instanceof HolderTwo) {
            HomeBean.DataBean.AreaBean areaBean = (AreaBean) mlist.get(position);
            List<AreaBean.ListscrollBean> listscroll = areaBean.getListscroll();
            LinearLayoutManager manager = new LinearLayoutManager(App.context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((HolderTwo) holder).homeAreaRecy.setLayoutManager(manager);
            ((HolderTwo) holder).homeAreaRecy.setAdapter(new HomeAreaRecyAdapter((ArrayList<AreaBean.ListscrollBean>) listscroll));

        }
        if (holder instanceof HolderThree) {
            PandaeyeBean pandaeyeBean = (PandaeyeBean) mlist.get(position);
            Glide.with(App.context).load(pandaeyeBean.getPandaeyelogo()).into(((HolderThree) holder).home_pandaeye_img);
            List<PandaeyeBean.ItemsBean> items = pandaeyeBean.getItems();
            PandaeyeBean.ItemsBean itemsBean1 = items.get(0);
            ((HolderThree) holder).home_pandaeye_title.setText(itemsBean1.getTitle());
            PandaeyeBean.ItemsBean itemsBean2 = items.get(1);
            ((HolderThree) holder).home_pandaeye_title2.setText(itemsBean2.getTitle());
            update.setData(((HolderThree) holder).home_pandaeye_recyc);

        }
        if (holder instanceof HolderFour) {
            HomeBean.DataBean.PandaliveBean pandaliveBean = (PandaliveBean) mlist.get(position);
            HomePandaLiveAdapter homePandaLiveAdapter = new HomePandaLiveAdapter((ArrayList<PandaliveBean.ListBean>) pandaliveBean.getList());
            ((HolderFour) holder).home_pandaLiveRecy.setLayoutManager(new GridLayoutManager(App.context, 3));
            ((HolderFour) holder).home_pandaLiveRecy.setAdapter(homePandaLiveAdapter);

        }
        if (holder instanceof HolderFive) {
            HomeBean.DataBean.WallliveBean wallliveBean = (WallliveBean) mlist.get(position);
            ((HolderFive) holder).homewallLiveRecy.setAdapter(new HomeWallLiveAdapter((ArrayList<WallliveBean.ListBean>) wallliveBean.getList()));
            ((HolderFive) holder).homewallLiveRecy.setLayoutManager(new GridLayoutManager(App.context, 3));

        }
        if (holder instanceof HolderSix) {
            HomeBean.DataBean.ChinaliveBean chinaliveBean = (ChinaliveBean) mlist.get(position);
            ((HolderSix) holder).home_chinaliverecy.setLayoutManager(new GridLayoutManager(App.context, 3));
            ((HolderSix) holder).home_chinaliverecy.setAdapter(new HomeChinaLiveAdapter((ArrayList<ChinaliveBean.ListBean>) chinaliveBean.getList()));

        }
        if (holder instanceof HolderSeven) {
            HomeBean.DataBean.InteractiveBean interactiveBean = (InteractiveBean) mlist.get(position);
            Glide.with(App.context).load(interactiveBean.getInteractiveone().get(0).getImage()).into(((HolderSeven) holder).home_specialimage);
            ((HolderSeven) holder).home_specialText.setText(interactiveBean.getInteractiveone().get(0).getTitle());
        }
        if (holder instanceof HolderEight) {
            updatetwo.setDataTwo(((HolderEight) holder).home_cctv_recy);

        }
        if (holder instanceof HolderNine) {
            updatethree.setDataThree(((HolderNine) holder).home_gychinaRecy);

        }

        holder.itemView.setTag(position);
    }
    public interface UpdataIntertwo {
        void setDataTwo(RecyclerView stu);
    }

    private UpdataIntertwo updatetwo;

    public void getDataTwo(UpdataIntertwo updatetwo) {
        this.updatetwo = updatetwo;
    }

    public interface UpdataInterthree {
        void setDataThree(RecyclerView stu);
    }

    private UpdataInterthree updatethree;

    public void getDataThree(UpdataInterthree updatethree) {
        this.updatethree = updatethree;
    }

    public interface UpdataInter {
        void setData(RecyclerView recyclerView);
    }

    private UpdataInter update;

    public void getData(UpdataInter update) {
        this.update = update;
    }


    @Override
    public int getItemViewType(int position) {
        for (int i = 0; i < 9; i++) {
            if (i == position) {
                return i;
            }
        }
        return 0;
    }


    @Override
    public int getItemCount() {
        return mlist.isEmpty() ? 0 : mlist.size();
    }

    @Override
    public void OnBannerClick(int position) {

    }


    class HolderOne extends RecyclerView.ViewHolder {
        private Banner homeBanner;

        public HolderOne(View itemView) {
            super(itemView);
            homeBanner = itemView.findViewById(R.id.homeBanner);
        }
    }

    class HolderTwo extends RecyclerView.ViewHolder {
        private RecyclerView homeAreaRecy;

        public HolderTwo(View itemView) {
            super(itemView);
            homeAreaRecy = itemView.findViewById(R.id.homeAreaRecy);
        }
    }

    class HolderThree extends RecyclerView.ViewHolder {
        private ImageView home_pandaeye_img;
        private TextView home_pandaeye_title;
        private TextView home_pandaeye_title2;
        private RecyclerView home_pandaeye_recyc;

        public HolderThree(View itemView) {
            super(itemView);
            home_pandaeye_img = itemView.findViewById(R.id.home_pandaeye_img);
            home_pandaeye_title = itemView.findViewById(R.id.home_pandaeye_title);
            home_pandaeye_title2 = itemView.findViewById(R.id.home_pandaeye_title2);
            home_pandaeye_recyc = itemView.findViewById(R.id.home_pandaeye_recyc);


        }
    }

    class HolderFour extends RecyclerView.ViewHolder {

        private RecyclerView home_pandaLiveRecy;

        public HolderFour(View itemView) {
            super(itemView);
            home_pandaLiveRecy = itemView.findViewById(R.id.home_pandaLiveRecy);

        }
    }

    class HolderFive extends RecyclerView.ViewHolder {
        private RecyclerView homewallLiveRecy;
        ;

        public HolderFive(View itemView) {
            super(itemView);
            homewallLiveRecy = itemView.findViewById(R.id.homewallLiveRecy);


        }
    }

    class HolderSix extends RecyclerView.ViewHolder {
        RecyclerView home_chinaliverecy;

        public HolderSix(View itemView) {
            super(itemView);
            home_chinaliverecy = itemView.findViewById(R.id.home_chinaliverecy);

        }
    }

    class HolderSeven extends RecyclerView.ViewHolder {

        private ImageView home_specialimage;
        private TextView home_specialText;

        public HolderSeven(View itemView) {
            super(itemView);
            home_specialimage = itemView.findViewById(R.id.home_specialimage);
            home_specialText = itemView.findViewById(R.id.home_specialText);


        }
    }

    class HolderEight extends RecyclerView.ViewHolder {

        private RecyclerView home_cctv_recy;

        public HolderEight(View itemView) {
            super(itemView);
            home_cctv_recy = itemView.findViewById(R.id.home_CCTV_recy);

        }
    }

    class HolderNine extends RecyclerView.ViewHolder {

        private  RecyclerView home_gychinaRecy;

        public HolderNine(View itemView) {
            super(itemView);

            home_gychinaRecy = itemView.findViewById(R.id.home_gychinaRecy);
        }
    }


}
