package com.osetrova.app.randomtify.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class Song {

    @EmbeddedId
    private SongId id;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private String album;

    @Column(nullable = false)
    private int year;

    private String comment;
}
