package com.osetrova.app.randomtify.service;

import com.osetrova.app.randomtify.model.dto.response.RandomArtistResponse;
import com.osetrova.app.randomtify.model.search.Alphabet;

import java.util.List;

public interface SearchService {

    RandomArtistResponse search(Alphabet alphabet, String query, Integer charsAmount);
    List<Alphabet> getAlphabets();
}
