package com.osetrova.app.randomtify.service;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;
import com.osetrova.app.randomtify.model.entity.Rating;

import java.util.List;
import java.util.Map;

public interface ArtistService {

    ArtistResponseExtended getByName(String name);

    List<ArtistResponse> getAll();

    void updateRating(Map<String, Rating> ratingUpdates);
}
