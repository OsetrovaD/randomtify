package com.osetrova.app.randomtify.service.impl;

import com.osetrova.app.randomtify.mapper.SongMapper;
import com.osetrova.app.randomtify.model.dto.request.SongDto;
import com.osetrova.app.randomtify.model.dto.response.SavedSongsResponse;
import com.osetrova.app.randomtify.model.entity.Song;
import com.osetrova.app.randomtify.repository.SongRepository;
import com.osetrova.app.randomtify.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    @Transactional
    public SavedSongsResponse save(List<SongDto> songRequests, String artistName) {
        List<SongDto> saved = new ArrayList<>();
        List<Song> songs = songRequests.stream()
                .filter(songRequest -> songRepository.existsByIdArtistAndIdName(artistName, songRequest.getName()))
                .peek(saved::add)
                .map(songRequest -> songMapper.map(songRequest, artistName))
                .toList();
        songRepository.saveAll(songs);
        return new SavedSongsResponse(artistName, saved);
    }

    @Override
    public void update(List<SongDto> updateRequest, String artistName) {
        List<Song> toUpdate = new ArrayList<>();
        for (SongDto songUpdate : updateRequest) {
            mapUpdates(songUpdate, artistName, toUpdate);
        }
        songRepository.saveAll(toUpdate);
    }

    @Override
    public void delete(String songName, String artistName) {
        songRepository.deleteByIdArtistAndIdName(artistName, songName);
    }

    private void mapUpdates(SongDto updateRequest, String artistName, List<Song> toUpdate) {
        songRepository.findByIdArtistAndIdName(artistName, updateRequest.getName())
                .map(song -> songMapper.update(song, updateRequest))
                .ifPresent(toUpdate::add);
    }
}
