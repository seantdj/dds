package com.sean.dds.config;

import lombok.Data;

/**
 * @author tengdj
 * @date 2020/2/26 15:47
 **/
@Data
public class DataSourceProperties {

    String type;

    String url;

    String userName;

    String password;

    String driverClassName;

}
