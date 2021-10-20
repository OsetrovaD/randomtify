package com.osetrova.app.randomtify.repository;

import com.osetrova.app.randomtify.model.entity.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ArtistRepository extends CrudRepository<Artist, UUID> {
}
