package com.osetrova.app.randomtify.service;

import com.osetrova.app.randomtify.model.dto.request.SongDto;
import com.osetrova.app.randomtify.model.dto.response.SavedSongsResponse;

import java.util.List;

public interface SongService {

    SavedSongsResponse save(List<SongDto> songs, String artistName);

    void update(List<SongDto> updateRequest, String artistName);

    void delete(String songName, String artistName);
}
