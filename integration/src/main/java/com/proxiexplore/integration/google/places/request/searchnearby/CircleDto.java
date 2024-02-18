package com.proxiexplore.integration.google.places.request.searchnearby;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CircleDto {
    private CenterDto center;
    private double radius;
}
