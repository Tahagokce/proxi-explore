package com.proxiexplore.placesservice.converter;

import com.proxiexplore.entity.place.Place;
import com.proxiexplore.entity.place.PlaceGeoLocation;
import com.proxiexplore.integration.google.places.response.searchnearby.PlacesDto;
import com.proxiexplore.integration.google.places.response.searchnearby.SearchNearbyResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PlaceConverter {
    
    public Place toEntity(PlacesDto dto){
        return Place.builder()
                .id(dto.getId())
                .internationalPhoneNumber(dto.getInternationalPhoneNumber())
                .formattedAddress(dto.getFormattedAddress())
                .geo(PlaceGeoLocation.builder()
                        .lat(dto.getLocation().getLatitude())
                        .lon(dto.getLocation().getLongitude())
                        .build())
                .primaryTypeDisplayName(dto.getPrimaryTypeDisplayName())
                .displayName(dto.getDisplayName())
                .build();
    }

    public List<Place> toEntity(SearchNearbyResponse searchNearbyResponse){
        if (Objects.isNull(searchNearbyResponse) || searchNearbyResponse.getPlaces().isEmpty()){
            return new ArrayList<>();
        }

        return searchNearbyResponse.getPlaces().stream().map(this::toEntity).toList();
    }
}
