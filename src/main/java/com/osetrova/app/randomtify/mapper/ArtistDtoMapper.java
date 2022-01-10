package com.osetrova.app.randomtify.mapper;

import com.osetrova.app.randomtify.client.dto.ArtistDto;
import com.osetrova.app.randomtify.model.dto.response.RandomArtistResponse;
import com.osetrova.app.randomtify.model.entity.Artist;
import com.osetrova.app.randomtify.model.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Rating.class)
public interface ArtistDtoMapper {

    @Mapping(target = "rating", expression = "java(Rating.UNRATED)")
    @Mapping(target = "spotifyUrl", source = "href")
    Artist map(ArtistDto searchResponse);

    RandomArtistResponse mapToResponse(ArtistDto searchResponse);
}
