package com.osetrova.app.randomtify.client;

import com.osetrova.app.randomtify.configuration.SpotifyConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SpotifyClient {

    private final WebClient webClient;

    public SpotifyClient(WebClient.Builder wcBuilder, SpotifyConfig spotifyConfig) {
        System.out.println(spotifyConfig);
        this.webClient = wcBuilder.baseUrl(spotifyConfig.getBaseUrl()).build();

    }
}
