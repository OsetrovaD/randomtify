package com.osetrova.app.randomtify.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.osetrova.app.randomtify.jackson.RatingDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonDeserialize(using = RatingDeserializer.class)
public enum Rating {

    UNRATED(0, "\u2606\u2606\u2606\u2606\u2606"),
    THERE_IS_SOMETHING(1, "\u2605\u2606\u2606\u2606\u2606"),
    NOT_BAD(2, "\u2605\u2605\u2606\u2606\u2606"),
    GOOD(3, "\u2605\u2605\u2605\u2606\u2606"),
    ALMOST_PERFECT(4, "\u2605\u2605\u2605\u2605\u2606"),
    SUPERB(5, "\u2605\u2605\u2605\u2605\u2605");

    @Getter
    private int value;

    @Getter(onMethod_ = @JsonValue)
    private String stars;
}
