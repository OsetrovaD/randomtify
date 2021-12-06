package com.osetrova.app.randomtify.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class SongId implements Serializable {

    @Column(nullable = false, updatable = false)
    private String artist;

    @Column(nullable = false, updatable = false)
    private String name;
}
