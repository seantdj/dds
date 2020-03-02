package com.sean.dds.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author tengdj
 * @date 2020/2/26 15:44
 **/
@Data
@ConfigurationProperties(prefix = "dds")
public class DdsProperties {

    private String defaultKey;

    private Map<String, DataSourceProperties> properties;

}
