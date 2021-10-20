package com.osetrova.app.randomtify.repository;

import com.osetrova.app.randomtify.model.entity.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SongRepository extends CrudRepository<Song, UUID> {
}
