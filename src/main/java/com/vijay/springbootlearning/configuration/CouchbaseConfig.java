package com.vijay.springbootlearning.configuration;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@EnableConfigurationProperties({CouchbaseProperties.class})
@EnableCouchbaseRepositories(basePackages = {"com.vijay.springbootlearning.repository"})
@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    private final CouchbaseProperties couchbaseProperties;
    private final CouchbaseDataProperties dataProperties;

    public CouchbaseConfig(CouchbaseProperties couchbaseProperties, CouchbaseDataProperties dataProperties) {
        this.couchbaseProperties = couchbaseProperties;
        this.dataProperties = dataProperties;
    }

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
        return dataProperties.getBucketName();
    }

    @Override
    public MappingCouchbaseConverter mappingCouchbaseConverter(CouchbaseMappingContext couchbaseMappingContext, CouchbaseCustomConversions couchbaseCustomConversions) {
        MappingCouchbaseConverter converter = new CustomMappingCouchbaseConverter(couchbaseMappingContext, this.typeKey());
        converter.setCustomConversions(couchbaseCustomConversions);
        return converter;
    }
    @Override
    public String typeKey() {
        return null; // this will override '_class'
    }
}
