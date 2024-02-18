package com.proxiexplore.placesservice.service.impl;

import com.proxiexplore.entity.location.Location;
import com.proxiexplore.placesservice.repository.LocationRepository;
import com.proxiexplore.placesservice.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Mono<Boolean> isExists(Double lon, Double lat, Long distance) {
        return locationRepository.existsByLonAndLatAndDistance(lon, lat, distance)
                .doOnError(error -> log.error(error.getMessage()));
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location)
                .doOnError(error -> log.error(error.getMessage()))
                .subscribe();
    }
}
