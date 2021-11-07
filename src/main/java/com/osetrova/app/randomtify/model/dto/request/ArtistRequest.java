package com.osetrova.app.randomtify.model.dto.request;

import com.osetrova.app.randomtify.model.entity.Rating;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArtistRequest {

    private String name;
    private Rating rating;
    private String spotifyUrl;
}
