package com.proxiexplore.integration.google.places.service.impl;

import com.proxiexplore.integration.google.places.client.PlacesClient;
import com.proxiexplore.integration.google.places.request.searchnearby.SearchNearbyRequest;
import com.proxiexplore.integration.google.places.response.searchnearby.SearchNearbyResponse;
import com.proxiexplore.integration.google.places.service.PlacesClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlacesClientServiceImpl implements PlacesClientService {

    private final WebClient webClient;

    @Override
    public Mono<SearchNearbyResponse> searchNearby(SearchNearbyRequest request){
        return PlacesClient.searchNearby(request, webClient);
    }
}
