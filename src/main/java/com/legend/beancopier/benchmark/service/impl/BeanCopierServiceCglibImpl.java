package com.legend.beancopier.benchmark.service.impl;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;
import com.legend.beancopier.benchmark.service.BeanCopierService;
import net.sf.cglib.beans.BeanCopier;

/**
 * Created by allen on 8/18/16.
 */
public class BeanCopierServiceCglibImpl implements BeanCopierService {
    public void copyFromMaster(MasterBean masterBean, SlaveBean slaveBean) {
        if (masterBean == null || slaveBean == null) {
            System.out.println("Parameter cannot be null.");
            return;
        }

        BeanCopier beanCopier = BeanCopier.create(MasterBean.class, SlaveBean.class, false);
        beanCopier.copy(masterBean, slaveBean, null);
    }
}
