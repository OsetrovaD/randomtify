package com.osetrova.app.randomtify.model.dto.response;

import java.util.List;

public interface ArtistResponseExtended extends ArtistResponse {

    List<SongProjection> getSongs();
}
