package com.osetrova.app.randomtify.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Rating {

    UNRATED(0, "\u2606\u2606\u2606\u2606\u2606"),
    THERE_IS_SOMETHING(1, "\u2605\u2606\u2606\u2606\u2606"),
    NOT_BAD(2, "\u2605\u2605\u2606\u2606\u2606"),
    GOOD(3, "\u2605\u2605\u2605\u2606\u2606"),
    ALMOST_PERFECT(4, "\u2605\u2605\u2605\u2605\u2606"),
    SUPERB(5, "\u2605\u2605\u2605\u2605\u2605");

    private int value;
    private String stars;
}
