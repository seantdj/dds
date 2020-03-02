package com.sean.dds.config;

import com.sean.dds.aop.DdsAspect;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tengdj
 * @date 2020/2/26 15:30
 **/
@Configuration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({DdsProperties.class, DdsPropertiesTest.class})
@ConditionalOnClass(DdsRegister.class)
@Import({DdsRegister.class, DdsAspect.class})
public class DdsAutoConfiguration {
}
