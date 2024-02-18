package com.proxiexplore.placesservice.service;

import com.proxiexplore.entity.location.Location;
import reactor.core.publisher.Mono;

public interface LocationService {
    Mono<Boolean> isExists(Double lon, Double lat, Long distance);

    void save(Location location);

}
