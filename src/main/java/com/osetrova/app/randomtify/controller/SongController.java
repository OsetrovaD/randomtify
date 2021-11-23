package com.osetrova.app.randomtify.controller;

import com.osetrova.app.randomtify.model.dto.request.SongDto;
import com.osetrova.app.randomtify.model.dto.response.SavedSongsResponse;
import com.osetrova.app.randomtify.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/artists/{artistName}/songs")
public class SongController {

    private final SongService songService;

    @PostMapping
    public ResponseEntity<SavedSongsResponse> save(@RequestBody List<SongDto> songsRequest,
                                                   @PathVariable String artistName) {
        SavedSongsResponse savedSongs = songService.save(songsRequest, artistName);
        return new ResponseEntity<>(savedSongs, HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String artistName, @PathVariable String name) {
        songService.delete(name, artistName);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody List<SongDto> updateRequest, @PathVariable String artistName) {
        songService.update(updateRequest, artistName);
    }
}
