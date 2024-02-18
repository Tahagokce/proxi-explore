package com.proxiexplore.entity.place;


import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;


@Document
@Scope("proxi-explore")
@Collection("places")
@CompositeQueryIndex(fields = {"id"})
@Builder
@Getter
@Setter
public class Place {

    @Id
    @Field
    private String id;

    @Field
    private String internationalPhoneNumber;

    @Field
    private String formattedAddress;

    @Field
    private PlaceGeoLocation geo;

    @Field
    private PlaceDisplayName primaryTypeDisplayName;

    @Field
    private PlaceDisplayName displayName;

}
