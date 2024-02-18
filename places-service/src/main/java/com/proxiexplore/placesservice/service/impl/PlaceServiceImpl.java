package com.proxiexplore.placesservice.service.impl;

import com.proxiexplore.common.model.request.SearchNearPlaces;
import com.proxiexplore.entity.location.Location;
import com.proxiexplore.entity.place.Place;
import com.proxiexplore.integration.google.places.request.searchnearby.SearchNearbyRequest;
import com.proxiexplore.integration.google.places.service.PlacesClientService;
import com.proxiexplore.placesservice.converter.PlaceConverter;
import com.proxiexplore.placesservice.repository.PlaceRepository;
import com.proxiexplore.placesservice.service.LocationService;
import com.proxiexplore.placesservice.service.PlaceService;
import com.proxiexplore.placesservice.service.fts.PlaceFTSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceFTSService placeFTSService;
    private final PlacesClientService placesClientService;
    private final PlaceConverter converter;
    private final LocationService locationService;

    @Override
    public Flux<Place> findByPlace(SearchNearPlaces search) {
        return searchIfNotSaved(search);
    }

    private Flux<Place> searchIfNotSaved(SearchNearPlaces search) {
        return locationService.isExists(search.getLon(), search.getLat(), search.getDistance())
                .flux()
                .flatMap(exists -> {

                    if (Boolean.FALSE.equals(exists)) {
                        createLocation(search);
                        return findNearbyPlacesAndSave(search);
                    }

                    return placeFTSService.getNearPlaces(search);
                });
    }

    @Override
    public Flux<Place> findNearbyPlacesAndSave(SearchNearPlaces search) {
        return placesClientService.searchNearby(SearchNearbyRequest.off(search))
                .filter(Objects::nonNull)
                .map(converter::toEntity)
                .flatMapMany(result -> placeRepository.saveAll(result).thenMany(Flux.fromIterable(result)))
                .doOnError(error -> log.error("Error occurred: {}", error.getMessage()));
    }

    private void createLocation(SearchNearPlaces search) {
        Location location = Location.builder()
                .lon(search.getLon())
                .lat(search.getLat())
                .distance(search.getDistance())
                .build();

        locationService.save(location);
    }
}
