package com.osetrova.app.randomtify.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spotify.rest")
@Getter
@Setter
public class SpotifyConfig {

    private String baseUrl;
    private String searchPath;
}
