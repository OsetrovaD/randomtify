package com.osetrova.app.randomtify.repository;

import com.osetrova.app.randomtify.model.dto.response.ArtistResponse;
import com.osetrova.app.randomtify.model.dto.response.ArtistResponseExtended;
import com.osetrova.app.randomtify.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, String> {

    List<ArtistResponse> findAllBy();

    Optional<ArtistResponseExtended> findByName(String name);
}
