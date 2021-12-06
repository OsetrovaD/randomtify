package com.osetrova.app.randomtify.mapper;

import com.osetrova.app.randomtify.model.dto.request.SongDto;
import com.osetrova.app.randomtify.model.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SongMapper {

    @Mapping(target = "id.artist", source = "artistName")
    @Mapping(target = "id.name", source = "request.name")
    Song map(SongDto request, String artistName);

    @Mapping(target = "id", ignore = true)
    Song update(@MappingTarget Song entity, SongDto request);
}
