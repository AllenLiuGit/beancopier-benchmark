package com.legend.beancopier.benchmark.service.impl;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;
import com.legend.beancopier.benchmark.service.BeanCopierService;


/**
 * Created by allen on 8/18/16.
 */
public class BeanCopierServiceNativeImpl implements BeanCopierService {
    public void copyFromMaster(MasterBean masterBean, SlaveBean slaveBean) {
        if (masterBean == null || slaveBean == null) {
            System.out.println("Parameter cannot be null.");
            return;
        }
        slaveBean.setLocalInt(masterBean.getLocalInt());
        slaveBean.setLocalDouble(masterBean.getLocalDouble());
        slaveBean.setLocalDate(masterBean.getLocalDate());
        slaveBean.setLocalString(masterBean.getLocalString());
    }
}
