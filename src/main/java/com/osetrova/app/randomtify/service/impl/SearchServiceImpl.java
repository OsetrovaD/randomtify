package com.osetrova.app.randomtify.service.impl;

import com.osetrova.app.randomtify.client.SpotifyClient;
import com.osetrova.app.randomtify.client.dto.ArtistDto;
import com.osetrova.app.randomtify.client.dto.SpotifySearchResponse;
import com.osetrova.app.randomtify.mapper.ArtistDtoMapper;
import com.osetrova.app.randomtify.model.dto.response.RandomArtistResponse;
import com.osetrova.app.randomtify.model.search.Alphabet;
import com.osetrova.app.randomtify.service.ArtistService;
import com.osetrova.app.randomtify.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_MAX_CHARS_AMOUNT = 4;
    private static final int MAX_PAGES_INCLUSIVE = 999;

    private final SpotifyClient spotifyClient;
    private final ArtistService artistService;
    private final ArtistDtoMapper mapper;

    @Override
    public RandomArtistResponse search(Alphabet alphabet, String query, Integer charsAmount) {
        ArtistDto result = null;
        if (StringUtils.isNotBlank(query)) {
            result = getResponse(query);
        } else if (alphabet != null) {
            while (result == null) {
                String searchQuery = getQueryFromAlphabet(alphabet, charsAmount);
                result = getResponse(searchQuery);
            }
        } else {
            while (result == null) {
                Alphabet[] alphabets = Alphabet.values();
                Alphabet randomAlphabet = alphabets[RANDOM.nextInt(alphabets.length)];
                String searchQuery = getQueryFromAlphabet(randomAlphabet, charsAmount);
                result = getResponse(searchQuery);
            }
        }
        if (result != null) {
            artistService.save(mapper.map(result));
        }
        return mapper.mapToResponse(result);
    }

    @Override
    public List<Alphabet> getAlphabets() {
        return List.of(Alphabet.values());
    }

    private String getQueryFromAlphabet(Alphabet alphabet, Integer charsAmount) {
        StringBuilder result = new StringBuilder();
        if (charsAmount == null || charsAmount == 0) {
            charsAmount = RANDOM.nextInt(DEFAULT_MAX_CHARS_AMOUNT) + 1;
        }
        char[] alphabetChars = alphabet.getChars();
        int alphabetCharsAmount = alphabetChars.length;
        for (int i = 0; i < charsAmount; i++) {
            int charIndex = RANDOM.nextInt(alphabetCharsAmount);
            result.append(alphabetChars[charIndex]);
        }
        return result.toString();
    }

    private ArtistDto getResponse(String query) {
        SpotifySearchResponse response = spotifyClient.findArtist(query, RANDOM.nextInt(MAX_PAGES_INCLUSIVE) + 1);
        ArtistDto result = null;
        if (!response.getArtists().getItems().isEmpty()) {
            result = response.getArtists().getItems().get(0);
        } else if (response.getArtists().getTotal() > 1) {
            response = spotifyClient.findArtist(query, RANDOM.nextInt(response.getArtists().getTotal()) + 1);
            result = response.getArtists().getItems().get(0);
        }
        return result;
    }
}
