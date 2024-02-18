package com.proxiexplore.integration.google.properties;

import com.proxiexplore.common.util.ApplicationContextWrapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("integration.google")
@Getter
@Setter
public class GoogleProperties {
    private String baseUrl;

    private String key;

    @NestedConfigurationProperty
    private ApiProperties api;

    public static GoogleProperties getInstance() {
        return ApplicationContextWrapper.getBean(GoogleProperties.class);
    }
}
