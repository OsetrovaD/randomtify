package com.osetrova.app.randomtify.client;

import com.osetrova.app.randomtify.client.dto.SpotifySearchResponse;

public interface SpotifyClient {

    SpotifySearchResponse findArtist(String artistNameQuery);
}
