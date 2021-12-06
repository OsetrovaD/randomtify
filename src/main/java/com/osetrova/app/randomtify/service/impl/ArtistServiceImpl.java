package com.osetrova.app.randomtify.service.impl;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;
import com.osetrova.app.randomtify.model.entity.Artist;
import com.osetrova.app.randomtify.model.entity.Rating;
import com.osetrova.app.randomtify.repository.ArtistRepository;
import com.osetrova.app.randomtify.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public ArtistResponseExtended getByName(String name) {
        return artistRepository.findByName(name)
                .orElse(null); //todo: not found
    }

    @Override
    public List<ArtistResponse> getAll() {
        return artistRepository.findAllBy();
    }

    @Override
    @Transactional
    public void updateRating(Map<String, Rating> ratingUpdates) {
        List<Artist> artists = artistRepository.findAllByNameIn(ratingUpdates.keySet());
        artists.forEach(artist -> artist.setRating(ratingUpdates.get(artist.getName())));
        artistRepository.saveAll(artists);
    }
}
