package com.proxiexplore.placesservice.service.fts;


import com.proxiexplore.common.model.request.SearchNearPlaces;
import com.proxiexplore.entity.place.Place;
import reactor.core.publisher.Flux;

public interface PlaceFTSService {
    Flux<Place> getNearPlaces(SearchNearPlaces search);
}
