package com.proxiexplore.integration.couchbase.fts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FtsQuery {
    private List<Double> location;
    private String distance;
    private String field;
    private int size;
    private int from;
    private Boolean explain;
    private List<String> sort;
    private Boolean includeLocations;

    @JsonProperty("search_after")
    private Object searchAfter;

    @JsonProperty("search-before")
    private Object searchBefore;
}
