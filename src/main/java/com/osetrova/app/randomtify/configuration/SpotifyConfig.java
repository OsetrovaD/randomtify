package com.osetrova.app.randomtify.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spotify.rest")
@Getter
@Setter
@ToString
public class SpotifyConfig {

    private String baseUrl;
    private String searchPath;
}
