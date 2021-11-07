package com.osetrova.app.randomtify.service.impl;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;
import com.osetrova.app.randomtify.repository.ArtistRepository;
import com.osetrova.app.randomtify.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
