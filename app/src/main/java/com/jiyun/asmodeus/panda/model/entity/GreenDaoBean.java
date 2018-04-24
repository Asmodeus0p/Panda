package com.jiyun.asmodeus.panda.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenDaoBean {
   private String url;
   private String title;
   private String imageurl;
   @Generated(hash = 502260879)
   public GreenDaoBean(String url, String title, String imageurl) {
       this.url = url;
       this.title = title;
       this.imageurl = imageurl;
   }
   @Generated(hash = 826843181)
   public GreenDaoBean() {
   }
   public String getUrl() {
       return this.url;
   }
   public void setUrl(String url) {
       this.url = url;
   }
   public String getTitle() {
       return this.title;
   }
   public void setTitle(String title) {
       this.title = title;
   }
   public String getImageurl() {
       return this.imageurl;
   }
   public void setImageurl(String imageurl) {
       this.imageurl = imageurl;
   }

}
