package com.proxiexplore.integration.google.properties;

import com.proxiexplore.common.util.ApplicationContextWrapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("integration.google.api")
@Getter
@Setter
public class ApiProperties {
    @NestedConfigurationProperty
    private PlacesProperties places;

    public static ApiProperties getInstance() {
        return ApplicationContextWrapper.getBean(ApiProperties.class);
    }
}
