package com.legend.beancopier.benchmark.service.impl;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;
import com.legend.beancopier.benchmark.service.BeanCopierService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by allen on 8/18/16.
 */
public class BeanCopierServiceApacheImpl implements BeanCopierService {
    public void copyFromMaster(MasterBean masterBean, SlaveBean slaveBean) {
        try {
            BeanUtils.copyProperties(slaveBean, masterBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
