package com.osetrova.app.randomtify.model.dto.response;

import com.osetrova.app.randomtify.model.entity.Rating;

import java.util.List;

public interface ArtistResponseExtended {

    String getSpotifyUrl();
    String getName();
    Rating getRating();
    List<SongProjection> getSongs();
}
