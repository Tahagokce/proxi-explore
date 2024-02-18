package com.proxiexplore.integration.google.places.request.searchnearby;

import com.proxiexplore.common.model.request.SearchNearPlaces;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SearchNearbyRequest {
    private List<String> includedTypes = new ArrayList<>();
    private long maxResultCount = 20;
    private LocationRestrictionDto locationRestriction;

    public static SearchNearbyRequest off(SearchNearPlaces search){
        SearchNearbyRequest request = new SearchNearbyRequest();
        LocationRestrictionDto dto = new LocationRestrictionDto();
        CircleDto circle = new CircleDto();
        CenterDto center = new CenterDto();

        center.setLatitude(search.getLat());
        center.setLongitude(search.getLon());

        circle.setCenter(center);
        circle.setRadius(search.getDistance());

        dto.setCircle(circle);

        request.setLocationRestriction(dto);
        return request;
    }
}
