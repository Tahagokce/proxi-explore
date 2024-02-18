package com.proxiexplore.placesservice.repository;

import com.proxiexplore.entity.location.Location;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Mono;

public interface LocationRepository extends ReactiveCouchbaseRepository<Location, String>, DynamicProxyable<LocationRepository> {
    Mono<Boolean> existsByLonAndLatAndDistance(Double lon, Double lat, Long distance);
}
