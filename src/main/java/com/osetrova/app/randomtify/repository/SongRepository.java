package com.osetrova.app.randomtify.repository;

import com.osetrova.app.randomtify.model.entity.Song;
import com.osetrova.app.randomtify.model.entity.SongId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, SongId> {

    boolean existsByIdArtistAndIdName(String artistName, String songName);

    Optional<Song> findByIdArtistAndIdName(String artistName, String songName);

    void deleteByIdArtistAndIdName(String artistName, String songName);
}
