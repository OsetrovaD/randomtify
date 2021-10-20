package com.osetrova.app.randomtify.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Artist extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String spotifyUrl;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private List<Song> songs;
}
