package com.proxiexplore.integration.google.places.response.searchnearby;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SearchNearbyResponse {
    private List<PlacesDto> places = new ArrayList<>();
}
