package com.osetrova.app.randomtify.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.osetrova.app.randomtify.model.entity.Rating;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RatingDeserializer extends StdDeserializer<Rating> {

    private final Map<Integer, Rating> valueRating = Arrays.stream(Rating.values())
            .collect(Collectors.toMap(Rating::getValue, Function.identity()));

    public RatingDeserializer() {
        this(null);
    }

    protected RatingDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Rating deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int rating = node.asInt();
        return valueRating.get(rating);
    }
}
