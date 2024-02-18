package com.proxiexplore.placesservice.repository;

import com.proxiexplore.entity.place.Place;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Scope("proxi-explore")
@Collection("places")
public interface PlaceRepository extends ReactiveCrudRepository<Place, String>, DynamicProxyable<PlaceRepository> {
}
