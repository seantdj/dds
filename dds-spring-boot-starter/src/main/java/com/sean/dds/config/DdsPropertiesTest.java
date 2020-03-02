package com.sean.dds.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tengdj
 * @date 2020/2/26 15:44
 **/
@Data
@ConfigurationProperties(prefix = "dda")
public class DdsPropertiesTest {

    private String defaultKey;

}
