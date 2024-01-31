package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty private final String _id;
    @JsonProperty private final String brandedFor;
    @JsonProperty private final String siren;
    @JsonProperty private final Address address;
    @JsonProperty private final String defaultPack;
    @JsonProperty private final String email;
    @JsonProperty private final boolean admin;
    @JsonProperty private final boolean activated;
    @JsonProperty private final ApiKeys apiKeys;

    @JsonCreator
    public Company(
            @JsonProperty("_id") final String _id,
            @JsonProperty("branded_for") final String brandedFor,
            @JsonProperty("siren") final String siren,
            @JsonProperty("address") final Address address,
            @JsonProperty("default_pack") final String defaultPack,
            @JsonProperty("email") final String email,
            @JsonProperty("admin") final boolean admin,
            @JsonProperty("activated") final boolean activated,
            @JsonProperty("api_keys") final ApiKeys apiKeys) {
        this._id = _id;
        this.brandedFor = brandedFor;
        this.siren = siren;
        this.address = address;
        this.defaultPack = defaultPack;
        this.email = email;
        this.admin = admin;
        this.activated = activated;
        this.apiKeys = apiKeys;
    }

    public String getId() {
        return _id;
    }

    public String getBrandedFor() {
        return brandedFor;
    }

    public String getSiren() {
        return siren;
    }

    public Address getAddress() {
        return address;
    }

    public String getDefaultPack() {
        return defaultPack;
    }

    public String getEmail() {
        return email;
    }

    public boolean getAdmin() {
        return admin;
    }

    public boolean getActivated() {
        return activated;
    }

    public ApiKeys getApiKeys() {
        return apiKeys;
    }

    @Override
    public String toString() {
        return "Company{" +
                "_id='" + _id + '\'' +
                ", branded_for='" + brandedFor + '\'' +
                ", siren='" + siren + '\'' +
                ", address='" + address + '\'' +
                ", default_pack='" + defaultPack + '\'' +
                ", email='" + email + '\'' +
                ", admin='" + admin + '\'' +
                ", activated='" + activated + '\'' +
                ", api_keys='" + apiKeys + '\'' +
                '}';
    }
}
