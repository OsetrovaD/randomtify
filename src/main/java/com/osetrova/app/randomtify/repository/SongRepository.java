package com.osetrova.app.randomtify.repository;

import com.osetrova.app.randomtify.model.entity.Song;
import com.osetrova.app.randomtify.model.entity.SongId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, SongId> {
}
