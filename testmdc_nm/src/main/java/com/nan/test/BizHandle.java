package com.nan.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class BizHandle  extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
    public static final String REQ_ID = "REQ_ID";

    private String funCode;

    public BizHandle(String funCode) {
        this.funCode = funCode;
    }

    public void run() {
        MDC.put(REQ_ID, UUID.randomUUID().toString());
        logger.info("开始调用服务{}，进行业务处理", funCode);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
        logger.info("服务{}处理完毕，可以释放空间了，避免内存泄露", funCode);
        MDC.remove(REQ_ID);
    }
/**
 * 总结：
 * 1，MDC提供的put方法，可以将一个K-V的键值对放到容器中，并且能保证同一个线程内，
 * key是唯一的，不同的线程MDC的值互不影响。
 * 2，在logback.xml中，在layout中可以通过声明 %X{REQ_ID} 来输出 MDC 中 REQ_ID 的信息；
 * 3，MDC 提供的 remove 方法，可以清除 MDC 中指定 key 对应的键值对信息。
 */
}
