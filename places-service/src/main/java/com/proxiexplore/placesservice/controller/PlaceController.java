package com.proxiexplore.placesservice.controller;


import com.proxiexplore.common.model.request.SearchNearPlaces;
import com.proxiexplore.entity.place.Place;
import com.proxiexplore.placesservice.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping
    public Flux<Place> getPlaces(@RequestBody @Valid SearchNearPlaces search){
        return placeService.findNearbyPlacesAndSave(search);
    }
}
