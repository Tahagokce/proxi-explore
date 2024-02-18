package com.proxiexplore.common.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class SearchNearPlaces {
    @NotNull
    private Double lat;

    @NotNull
    private Double lon;

    @NotNull
    private Long distance;

    public String generateSearch(){
        JSONObject request = new JSONObject();

        JSONObject query = new JSONObject();

        JSONObject location = new JSONObject();
        location.put("lon", lon);
        location.put("lat", lat);


        query.put("location", location);
        query.put("distance", distance.toString() + "mi");
        query.put("field", "geo");

        request.put("query", query);
        request.put("size", 20);
        request.put("from", 0);
        return request.toString();
    }
}
