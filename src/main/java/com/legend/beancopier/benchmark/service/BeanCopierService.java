package com.legend.beancopier.benchmark.service;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;

/**
 * Created by allen on 8/18/16.
 */
public interface BeanCopierService {
    public void copyFromMaster(MasterBean masterBean, SlaveBean slaveBean);
}
