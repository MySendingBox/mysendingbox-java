package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class Event {

    @JsonProperty
    private final String _id;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String category;
    @JsonProperty
    private final String description;
    @JsonProperty
    private final String letter;
    @JsonProperty
    private final String postcard;
    @JsonProperty
    private final String user;
    @JsonProperty
    private final Boolean webhookFailed;
    @JsonProperty
    private final Boolean webhookCalled;
    @JsonProperty
    private final ZonedDateTime createdAt;
    @JsonProperty
    private final ZonedDateTime updatedAt;

    @JsonCreator
    public Event(
            @JsonProperty("_id") final String _id,
            @JsonProperty("name") final String name,
            @JsonProperty("category") final String category,
            @JsonProperty("description") final String description,
            @JsonProperty("letter") final String letter,
            @JsonProperty("postcard") final String postcard,
            @JsonProperty("user") final String user,
            @JsonProperty("webhook_failed") final Boolean webhookFailed,
            @JsonProperty("webhook_called") final Boolean webhookCalled,
            @JsonProperty("created_at") final ZonedDateTime createdAt,
            @JsonProperty("updated_at") final ZonedDateTime updatedAt) {
        this._id = _id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.letter = letter;
        this.postcard = postcard;
        this.user = user;
        this.webhookFailed = webhookFailed;
        this.webhookCalled = webhookCalled;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }


    public String getLetter() {
        return letter;
    }


    public String getPostcard() {
        return postcard;
    }


    public String getUser() {
        return user;
    }


    public String getDescription() {
        return description;
    }

    public Boolean getWebhookCalled() {
        return webhookCalled;
    }

    public Boolean getWebhookFailed() {
        return webhookFailed;
    }


    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public String toString() {
        return "Events{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", letter='" + letter + '\'' +
                ", postcard='" + postcard + '\'' +
                ", user='" + user + '\'' +
                ", webhookFailed='" + webhookFailed + '\'' +
                ", webhookCalled='" + webhookCalled + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}