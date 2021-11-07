package com.osetrova.app.randomtify.service;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;

import java.util.List;

public interface ArtistService {

    ArtistResponseExtended getByName(String name);

    List<ArtistResponse> getAll();
}
