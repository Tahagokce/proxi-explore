package com.proxiexplore.integration.couchbase.fts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NearPlacesResponse {
    private FtsStatus status;
    private FtsQuery request;
    private List<FtsHit> hits;

    @JsonProperty("total-hits")
    private int totalHits;

    @JsonProperty("max-score")
    private double maxScore;
    private int took;
    private Object facets;
}
