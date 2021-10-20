package com.osetrova.app.randomtify.controller;

import com.osetrova.app.randomtify.client.SpotifyClient;
import com.osetrova.app.randomtify.client.dto.SpotifySearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spotify")
public class SpotifyController {

    private final SpotifyClient spotifyClient;

    @PostMapping
    public SpotifySearchResponse search() {
        //test request
        return spotifyClient.findArtist("?query=tania+bowra&offset=0&limit=20&type=artist");
    }
}
