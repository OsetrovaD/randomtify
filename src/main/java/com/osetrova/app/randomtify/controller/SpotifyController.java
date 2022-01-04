package com.osetrova.app.randomtify.controller;

import com.osetrova.app.randomtify.client.SpotifyClient;
import com.osetrova.app.randomtify.model.dto.response.RandomArtistResponse;
import com.osetrova.app.randomtify.model.search.Alphabet;
import com.osetrova.app.randomtify.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spotify/search")
public class SpotifyController {

    private final SpotifyClient spotifyClient;
    private final SearchService searchService;

//    @PostMapping
//    public SpotifySearchResponse search() {
//        //test request
//        return spotifyClient.findArtist("?query=tania+bowra&offset=0&limit=20&type=artist");
//    }

    @GetMapping
    public ResponseEntity<RandomArtistResponse> getArtist(@RequestParam(required = false) Alphabet alphabet,
                                                          @RequestParam(required = false) String query,
                                                          @RequestParam(required = false) Integer charsAmount) {
        RandomArtistResponse searchResponse = searchService.search(alphabet, query, charsAmount);
        return ResponseEntity.ok(searchResponse);
    }
}
