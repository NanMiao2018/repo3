package com.nan.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.UUID;

public class SimpleMDC {
    private static final Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
    public static final String REQ_ID = "REQ_ID";

    public static void main(String[] args) {
        MDC.put(REQ_ID, UUID.randomUUID().toString());
        logger.info("开始调用服务A，进行业务处理");
        logger.info("业务处理完毕，可以释放空间了，避免内存泄露");
        MDC.remove(REQ_ID);
        logger.info("REQ_ID 还有吗？{}", MDC.get(REQ_ID) != null);
    }

}
