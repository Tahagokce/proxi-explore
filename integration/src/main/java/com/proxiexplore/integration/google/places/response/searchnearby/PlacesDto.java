package com.proxiexplore.integration.google.places.response.searchnearby;

import com.proxiexplore.entity.place.PlaceDisplayName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlacesDto {
    private String id;

    private String internationalPhoneNumber;

    private String formattedAddress;

    private PlaceGeoLocation location;

    private PlaceDisplayName primaryTypeDisplayName;

    private PlaceDisplayName displayName;
}
