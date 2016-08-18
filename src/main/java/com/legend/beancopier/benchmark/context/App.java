package com.legend.beancopier.benchmark.context;

import com.legend.beancopier.benchmark.beans.MasterBean;
import com.legend.beancopier.benchmark.beans.SlaveBean;
import com.legend.beancopier.benchmark.service.BeanCopierService;
import com.legend.beancopier.benchmark.service.impl.BeanCopierServiceApacheImpl;
import com.legend.beancopier.benchmark.service.impl.BeanCopierServiceCglibImpl;
import com.legend.beancopier.benchmark.service.impl.BeanCopierServiceNativeImpl;
import com.legend.beancopier.benchmark.service.impl.BeanCopierServiceSpringImpl;

import java.util.Date;

/**
 * Created by allen on 8/18/16.
 */
public class App {
    public static MasterBean buildMaster() {
        MasterBean masterBean = new MasterBean();
        masterBean.setLocalInt(5);
        masterBean.setLocalDouble(10000000.00D);
        masterBean.setLocalDate(new Date());
        masterBean.setLocalString("Hello World!");

        return masterBean;
    }

    public static void beanCopierBenchmark(BeanCopierService beanCopierService, int loopCounts) {
        MasterBean masterBean = buildMaster();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCounts; i++) {
            SlaveBean slaveBean = new SlaveBean();
            beanCopierService.copyFromMaster(masterBean, slaveBean);
        }
        long stopTime = System.currentTimeMillis();

        System.out.println(beanCopierService.getClass().getCanonicalName() + " copy " + loopCounts + " times elapsed " + (stopTime - startTime) + "ms.");
    }

    public static void main(String[] args) {
        int loopCounts = 1000000;
        BeanCopierService beanCopierService = new BeanCopierServiceNativeImpl();
        beanCopierBenchmark(beanCopierService, loopCounts);
        beanCopierService = new BeanCopierServiceCglibImpl();
        beanCopierBenchmark(beanCopierService, loopCounts);
        beanCopierService = new BeanCopierServiceSpringImpl();
        beanCopierBenchmark(beanCopierService, loopCounts);
        beanCopierService = new BeanCopierServiceApacheImpl();
        beanCopierBenchmark(beanCopierService, loopCounts);
    }
}
