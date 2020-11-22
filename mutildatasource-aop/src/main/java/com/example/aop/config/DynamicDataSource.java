package com.example.aop.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:07
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
