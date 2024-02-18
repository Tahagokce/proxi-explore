package com.proxiexplore.integration.google.properties;

import com.proxiexplore.common.util.ApplicationContextWrapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "integration.google.api.places")
@Getter
@Setter
public class PlacesProperties {
    private String path;
    private String searchNearbyPath;
    private String fieldMask;

    public static PlacesProperties getInstance() {
        return ApplicationContextWrapper.getBean(PlacesProperties.class);
    }
}
