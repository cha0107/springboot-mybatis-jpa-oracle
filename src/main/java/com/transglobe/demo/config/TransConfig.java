package com.transglobe.demo.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import com.transglobe.demo.controller.TabAttrController;

@Configuration
public class TransConfig {

    @Bean(name = "txAdvice")
    public TransactionInterceptor txAdvice(PlatformTransactionManager platformTransactionManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(platformTransactionManager);
        Properties transactionAttribute = new Properties();

        transactionAttribute.setProperty("*", "readOnly,-Throwable");
        transactionAttribute.setProperty("create*", "PROPAGATION_REQUIRED,-Throwable");
        transactionAttribute.setProperty("update*", "PROPAGATION_REQUIRED,-Throwable");
        transactionAttribute.setProperty("delete*", "PROPAGATION_REQUIRED,-Throwable");
        transactionInterceptor.setTransactionAttributes(transactionAttribute);
        return transactionInterceptor;
    }

    @Bean
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        transactionAutoProxy.setProxyTargetClass(true);
        transactionAutoProxy.setBeanNames("*Service*");
        transactionAutoProxy.setInterceptorNames("txAdvice");
        return transactionAutoProxy;
    }

    // private static final int AOP_TIME_OUT = 50000;
    // private static final String AOP_POINTCUT_EXPRESSION = "execution(* com..*.service..*.*(..))";
    // @Autowired
    // private PlatformTransactionManager transactionManager;
    //
    // public TransConfig() {}
    //
    // @Bean
    // public TransactionInterceptor txAdvice() {
    // NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
    // RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
    // readOnlyTx.setReadOnly(true);
    // readOnlyTx.setPropagationBehavior(0);
    // RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
    // requiredTx.setRollbackRules(Collections.singletonList(new
    // RollbackRuleAttribute(Exception.class)));
    // requiredTx.setPropagationBehavior(0);
    // requiredTx.setTimeout(AOP_TIME_OUT);
    // Map<String, TransactionAttribute> methodMap = new HashMap<>();
    // methodMap.put("*", readOnlyTx);
    // methodMap.put("create*", requiredTx);
    // methodMap.put("update*", requiredTx);
    // methodMap.put("delete*", requiredTx);
    // source.setNameMap(methodMap);
    //
    // TransactionInterceptor txAdvice = new TransactionInterceptor();
    // txAdvice.setTransactionAttributeSource(source);
    // txAdvice.setTransactionManager(transactionManager);
    // return txAdvice;
    // }
    //
    // @Bean(name = {"txAdviceAdvisor"})
    // public Advisor txAdviceAdvisor() {
    // AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    // pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
    // return new DefaultPointcutAdvisor(pointcut, this.txAdvice());
    // }
}
