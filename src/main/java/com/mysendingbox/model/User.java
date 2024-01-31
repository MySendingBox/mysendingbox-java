package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty private final String _id;
    @JsonProperty private final String name;
    @JsonProperty private final String phone;
    @JsonProperty private final String role;
    @JsonProperty private final String company;
    @JsonProperty private final String email;
    @JsonProperty private final boolean admin;
    @JsonProperty private final boolean activated;
    @JsonProperty private final boolean invitePending;
    @JsonProperty private final String inviteToken;

    @JsonCreator
    public User(
            @JsonProperty("_id") final String _id,
            @JsonProperty("name") final String name,
            @JsonProperty("phone") final String phone,
            @JsonProperty("role") final String role,
            @JsonProperty("company") final String company,
            @JsonProperty("email") final String email,
            @JsonProperty("admin") final boolean admin,
            @JsonProperty("activated") final boolean activated,
            @JsonProperty("invite_pending") final boolean invitePending,
            @JsonProperty("invite_token") final String inviteToken) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.company = company;
        this.email = email;
        this.admin = admin;
        this.activated = activated;
        this.invitePending = invitePending;
        this.inviteToken = inviteToken;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
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

    public boolean getInvitePending() {
        return invitePending;
    }

    public String getInviteToken() {
        return inviteToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", admin='" + admin + '\'' +
                ", activated='" + activated + '\'' +
                ", invite_pending='" + invitePending + '\'' +
                ", invite_token='" + inviteToken + '\'' +
                '}';
    }
}
