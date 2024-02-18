package com.proxiexplore.integration.couchbase.fts.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FtsStatus {
    private int total;
    private int failed;
    private int successful;
}
