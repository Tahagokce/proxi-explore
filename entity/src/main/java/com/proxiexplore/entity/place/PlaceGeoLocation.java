package com.proxiexplore.entity.place;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class PlaceGeoLocation implements Serializable {
    private String accuracy = "ROOFTOP";
    private Double lat;
    private Double lon;
}
