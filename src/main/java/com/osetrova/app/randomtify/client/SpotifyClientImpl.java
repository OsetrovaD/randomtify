package com.osetrova.app.randomtify.client;

import com.osetrova.app.randomtify.client.dto.SpotifySearchResponse;
import com.osetrova.app.randomtify.configuration.SpotifyConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SpotifyClientImpl implements SpotifyClient {

    private final WebClient webClient;
    private final String searchUrl;

    public SpotifyClientImpl(WebClient.Builder wcBuilder, SpotifyConfig spotifyConfig) {
        this.webClient = wcBuilder.baseUrl(spotifyConfig.getBaseUrl()).build();
        this.searchUrl = spotifyConfig.getSearchPath();
    }

    public SpotifySearchResponse findArtist(String artistNameQuery) {
        return webClient
                .get()
                .uri(searchUrl + artistNameQuery)
                .retrieve()
                .bodyToMono(SpotifySearchResponse.class)
                .block();

    }
}
