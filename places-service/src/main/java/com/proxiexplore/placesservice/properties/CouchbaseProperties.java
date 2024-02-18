package com.proxiexplore.placesservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("spring.data.couchbase")
@Getter
@Setter
public class CouchbaseProperties {
    private String bucketName;
    private String scopeName;
    private String placesCollectionName;
    private String locationCollectionName;
}
