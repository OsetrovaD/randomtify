package com.osetrova.app.randomtify.controller;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;
import com.osetrova.app.randomtify.model.entity.Rating;
import com.osetrova.app.randomtify.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistResponse>> getAll() {
        return ResponseEntity.ok(artistService.getAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ArtistResponseExtended> getById(@PathVariable String name) {
        return ResponseEntity.ok(artistService.getByName(name));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateRatings(@RequestBody Map<String, Rating> ratingUpdates) {
        artistService.updateRating(ratingUpdates);
    }
}
