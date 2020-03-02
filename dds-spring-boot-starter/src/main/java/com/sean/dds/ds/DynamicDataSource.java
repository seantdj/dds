package com.sean.dds.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tengdj
 * @date 2020/2/26 15:35
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceKeyHolder.holder.get();
    }

}
