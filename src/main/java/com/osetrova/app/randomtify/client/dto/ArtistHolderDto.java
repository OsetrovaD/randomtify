package com.osetrova.app.randomtify.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtistHolderDto {

    private List<ArtistDto> items;
    private int limit;
    private int offset;
    private int total;
}
