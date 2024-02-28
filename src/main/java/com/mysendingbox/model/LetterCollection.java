package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LetterCollection extends MysendingboxCollection<Letter> {

    @JsonCreator
    public LetterCollection(
            @JsonProperty("letters") final List<Letter> letters) {
        super(letters);
    }

}
