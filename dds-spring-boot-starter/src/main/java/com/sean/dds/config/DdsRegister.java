package com.sean.dds.config;

import com.sean.dds.ds.DynamicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tengdj
 * @date 2020/2/26 16:08
 **/
public class DdsRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    public static Map<String, DataSource> targetDss = new HashMap<String, DataSource>(5);

    Environment environment;

    private Binder binder;

    private DdsProperties ddsProperties;

    @Value("${dda.default-key}")
    private String def;

    public void initDataSource() {
        ddsProperties = binder.bind("dds", DdsProperties.class).get();
        Map<String, DataSourceProperties> propertiesMap = ddsProperties.getProperties();
        for(String key : propertiesMap.keySet()){
            DataSourceProperties properties = propertiesMap.get(key);
            DataSource ds;
            if(properties.getType() != null && "com.alibaba.druid.pool.DruidDataSource".equals(properties.getType())){
//                初始化driud datasource
                ds = null;
            }else{
               ds = DataSourceBuilder.create().driverClassName(properties.getDriverClassName()).url(properties.getUrl())
                        .username(properties.getUserName()).password(properties.getPassword()).build();
            }

            targetDss.put(key, ds);
        }
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        initDataSource();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setSynthetic(true);
        beanDefinition.setBeanClass(DynamicDataSource.class);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", targetDss.get(ddsProperties.getDefaultKey()));
        mpv.addPropertyValue("targetDataSources", targetDss);
        registry.registerBeanDefinition("dataSource", beanDefinition);
/*
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.
        scanner.addIncludeFilter();*/

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.binder = Binder.get(environment);
    }
}
