package com.osetrova.app.randomtify.controller;

import com.osetrova.app.randomtify.model.dto.response.RandomArtistResponse;
import com.osetrova.app.randomtify.model.search.Alphabet;
import com.osetrova.app.randomtify.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spotify/search")
public class SpotifyController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<RandomArtistResponse> getArtist(@RequestParam(required = false) Alphabet alphabet,
                                                          @RequestParam(required = false) String query,
                                                          @RequestParam(required = false) Integer charsAmount) {
        RandomArtistResponse searchResponse = searchService.search(alphabet, query, charsAmount);
        return ResponseEntity.ok(searchResponse);
    }

    @GetMapping("/alphabets")
    public ResponseEntity<List<Alphabet>> getAlphabets() {
        return ResponseEntity.ok(searchService.getAlphabets());
    }
}
