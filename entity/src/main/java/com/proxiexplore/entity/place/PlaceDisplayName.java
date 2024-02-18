package com.proxiexplore.entity.place;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlaceDisplayName implements Serializable {
    private String languageCode;
    private String text;
}
