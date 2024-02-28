package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysendingbox.exception.APIException;
import com.mysendingbox.exception.AuthenticationException;
import com.mysendingbox.exception.InvalidRequestException;
import com.mysendingbox.exception.RateLimitException;
import com.mysendingbox.net.APIResource;
import com.mysendingbox.net.MysendingboxResponse;
import com.mysendingbox.net.RequestOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account extends APIResource {

    public static final String RESOURCE = "accounts";

    @JsonProperty protected final User user;
    @JsonProperty protected final Company company;

    @JsonCreator
    public Account(
            @JsonProperty("user") final User user,
            @JsonProperty("company") final Company company) {
        this.user = user;
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setEmail(String email) {
            params.put("email", email);
            return this;
        }

        public RequestBuilder setName(String name) {
            params.put("name", name);
            return this;
        }

        public RequestBuilder setPhone(String phone) {
            params.put("phone", phone);
            return this;
        }

        public RequestBuilder setWebhookURL(String webhookURL) {
            params.put("webhook_url", webhookURL);
            return this;
        }

        public RequestBuilder setCompanyName(String companyName) {
            params.put("company_name", companyName);
            return this;
        }

        public RequestBuilder setAddressLine1(String addressLine1) {
            params.put("address_line1", addressLine1);
            return this;
        }

        public RequestBuilder setAddressLine2(String addressLine2) {
            params.put("address_line2", addressLine2);
            return this;
        }

        public RequestBuilder setAddressPostalCode(String addressPostalCode) {
            params.put("address_postalcode", addressPostalCode);
            return this;
        }

        public RequestBuilder setAddressCity(String addressCity) {
            params.put("address_city", addressCity);
            return this;
        }

        public RequestBuilder setAddressCountry(String addressCountry) {
            params.put("address_country", addressCountry);
            return this;
        }

        public RequestBuilder setSiren(String siren) {
            params.put("siren", siren);
            return this;
        }

        public RequestBuilder setCancellationWindow(int cancellationWindow) {
            params.put("cancellation_window", cancellationWindow);
            return this;
        }

        public MysendingboxResponse<Account> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public MysendingboxResponse<Account> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.JSON, RESOURCE, params, Account.class, options);
        }

        public MysendingboxResponse<Account> update(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return update(id, null);
        }

        public MysendingboxResponse<Account> update(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.PUT, RequestType.JSON, String.format("%s/%s", RESOURCE, id), params, Account.class, options);
        }
    }

}
