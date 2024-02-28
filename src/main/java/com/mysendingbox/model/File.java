package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class File {

    @JsonProperty private final String url;

    @JsonCreator
    public File(
            @JsonProperty("url") final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "File{" +
                "url=" + url + '\'' +
                '}';
    }

}