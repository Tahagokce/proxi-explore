package com.proxiexplore.placesservice.config;

import com.couchbase.client.java.query.QueryScanConsistency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@Slf4j
@EnableTransactionManagement
@EnableReactiveCouchbaseRepositories
@RequiredArgsConstructor
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private final CouchbaseProperties couchbaseProperties;

    private final com.proxiexplore.placesservice.properties.CouchbaseProperties couchbaseEnvProperties;

    @Override
    public String getConnectionString() {
        return couchbaseProperties.getConnectionString();
    }

    @Override
    public String getUserName() {
        return couchbaseProperties.getUsername();
    }

    @Override
    public String getPassword() {
        return couchbaseProperties.getPassword();
    }

    @Override
    public String getBucketName() {
        return couchbaseEnvProperties.getBucketName();
    }

    @Override
    protected String getScopeName() {
        return couchbaseEnvProperties.getScopeName();
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }

    @Override
    public String typeKey() {
        return MappingCouchbaseConverter.TYPEKEY_SYNCGATEWAY_COMPATIBLE;
    }

    @Override
    public QueryScanConsistency getDefaultConsistency() {
        return QueryScanConsistency.REQUEST_PLUS;
    }
}
