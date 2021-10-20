package com.osetrova.app.randomtify.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(unique = true, nullable = false, updatable = false)
    private String name;
}
