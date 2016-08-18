package com.legend.beancopier.benchmark.service.impl;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;
import com.legend.beancopier.benchmark.service.BeanCopierService;
import org.springframework.beans.BeanUtils;

/**
 * Created by allen on 8/18/16.
 */
public class BeanCopierServiceSpringImpl implements BeanCopierService {
    public void copyFromMaster(MasterBean masterBean, SlaveBean slaveBean) {
        BeanUtils.copyProperties(masterBean, slaveBean);
    }
}
