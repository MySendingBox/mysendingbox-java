package com.mysendingbox.net;

import java.util.Objects;

import com.mysendingbox.Mysendingbox;

public class RequestOptions {
    public static RequestOptions getDefault() {
        return new RequestOptions(Mysendingbox.apiKey, Mysendingbox.apiVersion, null);
    }

    private final String apiKey;
    private final String mysendingboxVersion;
    private final String idempotencyKey;

    private RequestOptions(String apiKey, String mysendingboxVersion, String idempotencyKey) {
        this.apiKey = apiKey;
        this.mysendingboxVersion = mysendingboxVersion;
        this.idempotencyKey = idempotencyKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getMysendingboxVersion() {
        return mysendingboxVersion;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o instanceof RequestOptions) {
            RequestOptions that = (RequestOptions) o;
            
            if (!Objects.equals(this.apiKey, that.getApiKey())) {
                return false;
            }
            
            if (!Objects.equals(this.mysendingboxVersion, that.getMysendingboxVersion())) {
                return false;
            }
    
            if (!Objects.equals(this.idempotencyKey, that.getIdempotencyKey())) {
                return false;
            }       
            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(apiKey, mysendingboxVersion, idempotencyKey);
    }    

    public static final class Builder {
        private String apiKey;
        private String mysendingboxVersion;
        private String idempotencyKey;

        public Builder() {
            this.apiKey = Mysendingbox.apiKey;
            this.mysendingboxVersion = Mysendingbox.apiVersion;
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setMysendingboxVersion(String mysendingboxVersion) {
            this.mysendingboxVersion = mysendingboxVersion;
            return this;
        }

        public String getMysendingboxVersion() {
            return this.mysendingboxVersion;
        }

        public Builder setIdempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        public RequestOptions build() {
            return new RequestOptions(this.apiKey, this.mysendingboxVersion, this.idempotencyKey);
        }
    }

}
