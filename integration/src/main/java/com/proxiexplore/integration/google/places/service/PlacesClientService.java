package com.proxiexplore.integration.google.places.service;

import com.proxiexplore.integration.google.places.request.searchnearby.SearchNearbyRequest;
import com.proxiexplore.integration.google.places.response.searchnearby.SearchNearbyResponse;
import reactor.core.publisher.Mono;

public interface PlacesClientService {
    Mono<SearchNearbyResponse> searchNearby(SearchNearbyRequest request);
}
