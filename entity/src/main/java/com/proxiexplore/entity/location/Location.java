package com.proxiexplore.entity.location;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Document
@Scope("proxi-explore")
@Collection("location")
@CompositeQueryIndex(fields = {"id"})
@Builder
@Getter
@Setter
public class Location {

    @Id
    @Field
    @GeneratedValue(strategy = UNIQUE)
    private String id;

    @Field
    private Double lat;

    @Field
    private Double lon;

    @Field
    private Long distance;
}
