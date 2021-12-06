package com.osetrova.app.randomtify.model.dto.response;

import com.osetrova.app.randomtify.model.entity.Rating;

public interface ArtistResponse {

    String getSpotifyUrl();
    String getName();
    Rating getRating();
}
