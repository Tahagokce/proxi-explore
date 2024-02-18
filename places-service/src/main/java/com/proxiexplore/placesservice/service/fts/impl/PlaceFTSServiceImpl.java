package com.proxiexplore.placesservice.service.fts.impl;

import com.couchbase.client.java.search.SearchOptions;
import com.couchbase.client.java.search.SearchQuery;
import com.couchbase.client.java.search.queries.GeoDistanceQuery;
import com.couchbase.client.java.search.result.ReactiveSearchResult;
import com.couchbase.client.java.util.Coordinate;
import com.proxiexplore.common.model.request.SearchNearPlaces;
import com.proxiexplore.entity.place.Place;
import com.proxiexplore.placesservice.service.fts.PlaceFTSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.couchbase.core.ReactiveCouchbaseTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceFTSServiceImpl implements PlaceFTSService {
    private final ReactiveCouchbaseTemplate couchbaseTemplate;

    @Override
    public Flux<Place> getNearPlaces(SearchNearPlaces search) {
        SearchOptions searchOptions = SearchOptions.searchOptions()
                .skip(0)
                .limit(20)
                .fields("geo").includeLocations(true);

        GeoDistanceQuery query = SearchQuery.geoDistance(Coordinate.ofLonLat(search.getLon(), search.getLat()), search.getDistance().toString().concat("mi")).field("geo");

        Mono<ReactiveSearchResult> resultMono = couchbaseTemplate.getCouchbaseClientFactory()
                .getCluster()
                .reactive()
                .searchQuery("places-geo", query, searchOptions);

        return resultMono.flatMapMany(ReactiveSearchResult::rows)
                .map(row -> Place.builder().id(row.id()).build());
    }
}
