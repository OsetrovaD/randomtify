package com.osetrova.app.randomtify.model.dto.response;

import com.osetrova.app.randomtify.model.dto.request.SongDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavedSongsResponse {

    private String artist;
    private List<SongDto> songs;
}
