package com.osetrova.app.randomtify.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtistHolder {

    private List<Artist> items;
    private int limit;
    private int offset;
    private int total;
}
