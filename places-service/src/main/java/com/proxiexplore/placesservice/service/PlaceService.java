package com.proxiexplore.placesservice.service;

import com.proxiexplore.common.model.request.SearchNearPlaces;
import com.proxiexplore.entity.place.Place;
import reactor.core.publisher.Flux;

public interface PlaceService {
    Flux<Place> findByPlace(SearchNearPlaces request);

    Flux<Place> findNearbyPlacesAndSave(SearchNearPlaces search);
}
