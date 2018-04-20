package com.jiyun.asmodeus.panda.model.entity;

import java.util.List;

public class HomeBean {

   private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private AreaBean area;

        private PandaeyeBean pandaeye;

        private PandaliveBean pandalive;

        private WallliveBean walllive;


        private ChinaliveBean chinalive;
        /**
         * title : 特别策划
         * interactiveone : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626317442_981.jpg","title":"二十四节气\u2014\u2014芒种","url":"http://webapp.cctv.com/h5/travel/U80531QU7SY7.html","type":"","vid":"","order":"1"}]
         * interactivetwo : []
         */

        private InteractiveBean interactive;
        /**
         * title : 央视名栏
         * listlive : []
         * listurl : http://www.ipanda.com/kehuduan/shipinliebieye/cctvshipindicengye/index.json
         */

        private CctvBean cctv;
        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/16/1497597712866_826.jpg
         * title :
         * url : http://download.cntv.cn/app/ipanda/index.html
         * id : TITE1497597714712290
         * type : 6
         * stype :
         * pid :
         * vid :
         * order : 1
         */

        private List<BigImgBean> bigImg;
        /**
         * listUrl : http://www.ipanda.com/kehuduan/shipinliebieye/guangyingzhongguo/index.json
         * title : 《光影中国》
         * type : 2
         * order : 1
         */

        private List<ListBean> list;

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public PandaeyeBean getPandaeye() {
            return pandaeye;
        }

        public void setPandaeye(PandaeyeBean pandaeye) {
            this.pandaeye = pandaeye;
        }

        public PandaliveBean getPandalive() {
            return pandalive;
        }

        public void setPandalive(PandaliveBean pandalive) {
            this.pandalive = pandalive;
        }

        public WallliveBean getWalllive() {
            return walllive;
        }

        public void setWalllive(WallliveBean walllive) {
            this.walllive = walllive;
        }

        public ChinaliveBean getChinalive() {
            return chinalive;
        }

        public void setChinalive(ChinaliveBean chinalive) {
            this.chinalive = chinalive;
        }

        public InteractiveBean getInteractive() {
            return interactive;
        }

        public void setInteractive(InteractiveBean interactive) {
            this.interactive = interactive;
        }

        public CctvBean getCctv() {
            return cctv;
        }

        public void setCctv(CctvBean cctv) {
            this.cctv = cctv;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class AreaBean {
            private String title;
            private String image;
            private String url;
            private String id;
            /**
             * image : http://p1.img.cctvpic.com/photoworkspace/2017/06/12/2017061213503191970.jpg
             * url : http://live.ipanda.com/2017/06/12/VIDEwHnBh4Rl0GZ5BeHFcnlR170612.shtml
             * title : 搓澡的呢？小公主都要睡着了
             * videoLength :
             * id : TITE1497340387814143
             * pid : d2a828ca5cd0400f82c2adee5581fc17
             * vid :
             * order : 1
             */

            private List<ListscrollBean> listscroll;
            private List<?> listh;
            private List<?> lists;
            private List<?> topiclist;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<ListscrollBean> getListscroll() {
                return listscroll;
            }

            public void setListscroll(List<ListscrollBean> listscroll) {
                this.listscroll = listscroll;
            }

            public List<?> getListh() {
                return listh;
            }

            public void setListh(List<?> listh) {
                this.listh = listh;
            }

            public List<?> getLists() {
                return lists;
            }

            public void setLists(List<?> lists) {
                this.lists = lists;
            }

            public List<?> getTopiclist() {
                return topiclist;
            }

            public void setTopiclist(List<?> topiclist) {
                this.topiclist = topiclist;
            }

            public static class ListscrollBean {
                private String image;
                private String url;
                private String title;
                private String videoLength;
                private String id;
                private String pid;
                private String vid;
                private String order;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getVideoLength() {
                    return videoLength;
                }

                public void setVideoLength(String videoLength) {
                    this.videoLength = videoLength;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class PandaeyeBean {
            private String title;
            private String pandaeyelogo;
            private String pandaeyelist;
            /**
             * title : 东北虎五胞胎取名谐音为“东北欢迎你”
             * bgcolor : #ff0a5a
             * brief : 新生
             * url : http://panview.ipanda.com/2017/06/14/VIDEQ2MhA0Ejp9OgTUcZXJV0170614.shtml
             * id : TITE1497403113884217
             * pid : 26097f927eb34babad51340659d08fe1
             * vid :
             * order : 1
             */

            private List<ItemsBean> items;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPandaeyelogo() {
                return pandaeyelogo;
            }

            public void setPandaeyelogo(String pandaeyelogo) {
                this.pandaeyelogo = pandaeyelogo;
            }

            public String getPandaeyelist() {
                return pandaeyelist;
            }

            public void setPandaeyelist(String pandaeyelist) {
                this.pandaeyelist = pandaeyelist;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {
                private String title;
                private String bgcolor;
                private String brief;
                private String url;
                private String id;
                private String pid;
                private String vid;
                private String order;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getBgcolor() {
                    return bgcolor;
                }

                public void setBgcolor(String bgcolor) {
                    this.bgcolor = bgcolor;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class PandaliveBean {
            private String title;
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765186225_780.jpg
             * url :
             * title : 成都基地高清精切线路
             * id : ipanda
             * vid : http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json
             * order : 1
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class WallliveBean {
            private String title;
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453447161326_398.jpg
             * url :
             * title : 八达岭长城南四楼
             * id : bgws4
             * vid : http://www.ipanda.com/kehuduan/liebiao/badaling/index.json
             * order : 1
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class ChinaliveBean {
            private String title;
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274866009_775.jpg
             * url :
             * title : 【直播】张家界
             * id : zjjmht
             * vid : http://livechina.ipanda.com/zhangjiajie/01/index.shtml
             * order : 1
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class InteractiveBean {
            private String title;
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626317442_981.jpg
             * title : 二十四节气——芒种
             * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
             * type :
             * vid :
             * order : 1
             */

            private List<InteractiveoneBean> interactiveone;
            private List<?> interactivetwo;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<InteractiveoneBean> getInteractiveone() {
                return interactiveone;
            }

            public void setInteractiveone(List<InteractiveoneBean> interactiveone) {
                this.interactiveone = interactiveone;
            }

            public List<?> getInteractivetwo() {
                return interactivetwo;
            }

            public void setInteractivetwo(List<?> interactivetwo) {
                this.interactivetwo = interactivetwo;
            }

            public static class InteractiveoneBean {
                private String image;
                private String title;
                private String url;
                private String type;
                private String vid;
                private String order;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class CctvBean {
            private String title;
            private String listurl;
            private List<?> listlive;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getListurl() {
                return listurl;
            }

            public void setListurl(String listurl) {
                this.listurl = listurl;
            }

            public List<?> getListlive() {
                return listlive;
            }

            public void setListlive(List<?> listlive) {
                this.listlive = listlive;
            }
        }

        public static class BigImgBean {
            private String image;
            private String title;
            private String url;
            private String id;
            private String type;
            private String stype;
            private String pid;
            private String vid;
            private String order;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }

        public static class ListBean {
            private String listUrl;
            private String title;
            private String type;
            private String order;

            public String getListUrl() {
                return listUrl;
            }

            public void setListUrl(String listUrl) {
                this.listUrl = listUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }
}
