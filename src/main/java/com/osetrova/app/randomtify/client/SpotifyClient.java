package com.osetrova.app.randomtify.client;

import com.osetrova.app.randomtify.client.model.SpotifySearchResponse;

public interface SpotifyClient {

    SpotifySearchResponse findArtist(String artistNameQuery);
}
