package com.osetrova.app.randomtify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Artist extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String spotifyUrl;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private List<Song> songs;
}
