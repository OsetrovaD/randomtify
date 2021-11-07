package com.osetrova.app.randomtify.model.dto.response;

import com.osetrova.app.randomtify.model.entity.Rating;
import org.springframework.beans.factory.annotation.Value;

public interface SongProjection {

    @Value("#{target.id.name}")
    String getName();
    String getAlbum();
    int getYear();
    String getComment();
    Rating getRating();
}
