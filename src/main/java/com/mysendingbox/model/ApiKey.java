package com.mysendingbox.model;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiKey {

    @JsonProperty private final String key;
    @JsonProperty protected final ZonedDateTime createdAt;

    @JsonCreator
    public ApiKey(
            @JsonProperty("key") final String key,
            @JsonProperty("created_at") final ZonedDateTime createdAt) {
        this.key = key;
        this.createdAt = createdAt;
    }

    public String getKey() {
        return key;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "key='" + key + '\'' +
                "createdAt='" + createdAt + '\'' +
                '}';
    }

}
