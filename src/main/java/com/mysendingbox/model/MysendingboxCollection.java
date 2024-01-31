package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class MysendingboxCollection<T> {
    @JsonProperty private final List<T> letters;

    @JsonCreator
    public MysendingboxCollection(List<T> letters) {
        this.letters = letters;
    }

    public List<T> getData() {
        return letters;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
            "letters=" + letters +
            '}';

    }

}
