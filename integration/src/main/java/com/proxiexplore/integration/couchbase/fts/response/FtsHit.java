package com.proxiexplore.integration.couchbase.fts.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FtsHit {
    private String index;
    private String id;
    private double score;
    private List<Double> sort;
}
