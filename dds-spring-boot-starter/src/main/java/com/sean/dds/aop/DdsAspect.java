package com.sean.dds.aop;

import com.sean.dds.annotation.DS;
import com.sean.dds.config.DdsRegister;
import com.sean.dds.ds.DataSourceKeyHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.StringUtils;

/**
 * @author tengdj
 * @date 2020/2/26 17:57
 **/
@Aspect
@Component
@Order(0)
@Slf4j
public class DdsAspect {

    @Pointcut("@annotation(com.sean.dds.annotation.DS)")
    public void pointCut(){}

    @Before("pointCut() && @annotation(ds)")
    public void before(JoinPoint point, DS ds){
        if(!TransactionSynchronizationManager.isActualTransactionActive()){
            String key = ds.value();
            if(StringUtils.isEmpty(key)){
                log.error("切换数据源失败，数据源名称为空。Method=[{}]", point.getSignature().getName());
                return;
            }
            if(!DdsRegister.targetDss.containsKey(key)){
                log.error("切换数据源失败，数据源不存在。Method=[{}] key=[{}]", point.getSignature().getName(), key);
                return;
            }
            if(log.isDebugEnabled()){
                log.debug("动态切换数据源，Method=[{}] key=[{}]", point.getSignature().getName(), key);
            }
            DataSourceKeyHolder.setRoutingKey(key);
        }
    }

    @After("@annotation(ds)")
    public void after(JoinPoint point, DS ds){
        if(log.isDebugEnabled()){
            log.debug("清空数据源,Method=[{}]",point.getSignature().getName());
        }

        if(!TransactionSynchronizationManager.isActualTransactionActive()) {
            DataSourceKeyHolder.clearRoutingKey();
        }
    }

}
