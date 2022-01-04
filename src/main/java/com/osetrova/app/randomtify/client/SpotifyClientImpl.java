package com.osetrova.app.randomtify.client;

import com.osetrova.app.randomtify.client.dto.SpotifySearchResponse;
import com.osetrova.app.randomtify.configuration.SpotifyConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class SpotifyClientImpl implements SpotifyClient {

    private static final int DEFAULT_LIMIT = 1;

    private final WebClient webClient;
    private final String searchUrl;
    private final String base;

    public SpotifyClientImpl(WebClient.Builder wcBuilder, SpotifyConfig spotifyConfig) {
        this.webClient = wcBuilder.baseUrl(spotifyConfig.getBaseUrl()).build();
        this.base = spotifyConfig.getBaseUrl();
        this.searchUrl = spotifyConfig.getSearchPath();
    }

    public SpotifySearchResponse findArtist(String query, int offset) {
        URI uri = UriComponentsBuilder.fromUriString(base)
                .path(searchUrl)
                .queryParam("query", query)
                .queryParam("limit", DEFAULT_LIMIT)
                .queryParam("offset", offset)
                .queryParam("type", "artist")
                .encode()
                .build()
                .toUri();
        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(SpotifySearchResponse.class)
                .block();
    }
}
