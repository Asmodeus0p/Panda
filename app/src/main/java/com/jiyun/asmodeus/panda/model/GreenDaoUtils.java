package com.jiyun.asmodeus.panda.model;

import android.content.Context;

import com.maple.mylicecenter.greendao.DaoMaster;
import com.maple.mylicecenter.greendao.GreenDaoBeanDao;


public class GreenDaoUtils {

    public static GreenDaoBeanDao getInstance(Context context){
        DaoMaster.DevOpenHelper asd = new DaoMaster.DevOpenHelper(context, "asd");
        GreenDaoBeanDao greenDaoBeanDao = new DaoMaster(asd.getWritableDb()).newSession().getGreenDaoBeanDao();
        return greenDaoBeanDao;
    }
}
