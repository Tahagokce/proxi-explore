package com.proxiexplore.integration.google.places.client;

import com.proxiexplore.integration.google.places.request.searchnearby.SearchNearbyRequest;
import com.proxiexplore.integration.google.places.response.searchnearby.SearchNearbyResponse;
import com.proxiexplore.integration.google.properties.GoogleProperties;
import com.proxiexplore.integration.google.properties.PlacesProperties;
import lombok.experimental.UtilityClass;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@UtilityClass
public class PlacesClient {
    public Mono<SearchNearbyResponse> searchNearby(SearchNearbyRequest request, WebClient webClient) {
        GoogleProperties googleProperties = GoogleProperties.getInstance();
        PlacesProperties places = googleProperties.getApi().getPlaces();

        String url = googleProperties.getBaseUrl()
                .concat(places.getPath())
                .concat(places.getSearchNearbyPath());


        return webClient
                .post()
                .uri(url)
                .headers(httpHeaders -> {
                    httpHeaders.set("X-Goog-Api-Key", googleProperties.getKey());
                    httpHeaders.set("X-Goog-FieldMask", places.getFieldMask());
                })
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(SearchNearbyResponse.class);
    }
}
