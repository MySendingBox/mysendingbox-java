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

public class Letter extends APIResource {

    public static final String RESOURCE = "letters";

    public static Integer lastSourceFileIndex = 1;

    @JsonProperty
    protected final String _id;
    @JsonProperty
    protected final String channel;
    @JsonProperty
    protected final String description;
    @JsonProperty
    protected final String mode;
    @JsonProperty
    protected final Address to;
    @JsonProperty
    protected final Address from;
    @JsonProperty
    protected final String color;
    @JsonProperty
    protected final boolean bothSides;
    @JsonProperty
    protected final String addressPlacement;
    @JsonProperty
    protected final String postageType;
    @JsonProperty
    protected final String postageSpeed;
    @JsonProperty
    protected final boolean manageDeliveryProof;
    @JsonProperty
    protected final Integer pageCount;
    @JsonProperty
    protected final Integer pdfMargin;
    @JsonProperty
    protected final String envelope;
    @JsonProperty
    protected final com.mysendingbox.model.File file;
    @JsonProperty
    protected final com.mysendingbox.model.File filingProof;
    @JsonProperty
    protected final com.mysendingbox.model.File lostProof;
    @JsonProperty
    protected final com.mysendingbox.model.File returnToSenderProof;
    @JsonProperty
    protected final List<Event> events;
    @JsonProperty
    protected final Price price;
    @JsonProperty
    protected final String sourceFile;
    @JsonProperty
    protected final String sourceFileType;
    @JsonProperty
    protected final Integer sheetCount;
    @JsonProperty
    protected final String trackingNumber;
    @JsonProperty
    protected final LocalDate expectedDeliveryDate;
    @JsonProperty
    protected final ZonedDateTime createdAt;
    @JsonProperty
    protected final ZonedDateTime updatedAt;
    @JsonProperty
    protected final ZonedDateTime sendDate;
    @JsonProperty
    protected final Map<String, String> metadata;
    @JsonProperty
    protected final Map<String, String> variables;
    @JsonProperty
    protected final boolean canceled;
    @JsonProperty
    protected final String object;

    @JsonCreator
    public Letter(
            @JsonProperty("_id") final String _id,
            @JsonProperty("channel") final String channel,
            @JsonProperty("description") final String description,
            @JsonProperty("mode") final String mode,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("color") final String color,
            @JsonProperty("both_sides") final boolean bothSides,
            @JsonProperty("address_placement") final String addressPlacement,
            @JsonProperty("source_file_type") final String sourceFileType,
            @JsonProperty("source_file") final String sourceFile,
            @JsonProperty("postage_type") final String postageType,
            @JsonProperty("postage_speed") final String postageSpeed,
            @JsonProperty("manage_delivery_proof") final boolean manageDeliveryProof,
            @JsonProperty("page_count") final Integer pageCount,
            @JsonProperty("sheet_count") final Integer sheetCount,
            @JsonProperty("pdf_margin") final Integer pdfMargin,
            @JsonProperty("envelope") final String envelope,
            @JsonProperty("file") final com.mysendingbox.model.File file,
            @JsonProperty("filing_proof") final com.mysendingbox.model.File filingProof,
            @JsonProperty("lost_proof") final com.mysendingbox.model.File lostProof,
            @JsonProperty("return_to_sender_proof") final com.mysendingbox.model.File returnToSenderProof,
            @JsonProperty("tracking_events") final List<Event> events,
            @JsonProperty("price") final Price price,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("variables") final Map<String, String> variables,
            @JsonProperty("expected_delivery_date") final LocalDate expectedDeliveryDate,
            @JsonProperty("created_at") final ZonedDateTime createdAt,
            @JsonProperty("updated_at") final ZonedDateTime updatedAt,
            @JsonProperty("send_date") final ZonedDateTime sendDate,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("canceled") final boolean canceled,
            @JsonProperty("object") final String object) {
        this._id = _id;
        this.channel = channel;
        this.description = description;
        this.mode = mode;
        this.to = to;
        this.from = from;
        this.color = color;
        this.bothSides = bothSides;
        this.addressPlacement = addressPlacement;
        this.sourceFile = sourceFile;
        this.sourceFileType = sourceFileType;
        this.postageType = postageType;
        this.postageSpeed = postageSpeed;
        this.manageDeliveryProof = manageDeliveryProof;
        this.pageCount = pageCount;
        this.pdfMargin = pdfMargin;
        this.envelope = envelope;
        this.file = file;
        this.filingProof = filingProof;
        this.lostProof = lostProof;
        this.returnToSenderProof = returnToSenderProof;
        this.events = events;
        this.price = price;
        this.sheetCount = sheetCount;
        this.trackingNumber = trackingNumber;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sendDate = sendDate;
        this.metadata = metadata;
        this.variables = variables;
        this.canceled = canceled;
        this.object = object;

        lastSourceFileIndex = 1;
    }

    public String getId() {
        return _id;
    }

    public String getChannel() {
        return channel;
    }

    public String getDescription() {
        return description;
    }

    public String getMode() {
        return mode;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public String isColor() {
        return color;
    }

    public boolean isBothSides() {
        return bothSides;
    }

    public String getAddressPlacement() {
        return addressPlacement;
    }

    public String getPostageType() {
        return postageType;
    }

    public String getPostageSpeed() {
        return postageSpeed;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public String getSourceFileType() {
        return sourceFileType;
    }

    public boolean isManageDeliveryProof() {
        return manageDeliveryProof;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Price getPrice() {
        return price;
    }

    public Integer getPdfMargin() {
        return pdfMargin;
    }

    public String getEnvelope() {
        return envelope;
    }

    public List<Event> getEvents() {
        return events;
    }

    public com.mysendingbox.model.File getFile() {
        return file;
    }

    public com.mysendingbox.model.File getFilingProof() {
        return filingProof;
    }

    public com.mysendingbox.model.File getLostProof() {
        return lostProof;
    }

    public com.mysendingbox.model.File getReturnToSenderProof() {
        return returnToSenderProof;
    }

    public Integer getSheetCount() {
        return sheetCount;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime getSendDate() {
        return sendDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "_id='" + _id + '\'' +
                ", channel='" + channel + '\'' +
                ", description='" + description + '\'' +
                ", mode='" + mode + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", color=" + color +
                ", bothSides=" + bothSides +
                ", addressPlacement='" + addressPlacement + '\'' +
                ", sourceFile='" + sourceFile + '\'' +
                ", sourceFileType='" + sourceFileType + '\'' +
                ", postageType='" + postageType + '\'' +
                ", postageSpeed='" + postageSpeed + '\'' +
                ", manageDeliveryProof=" + manageDeliveryProof +
                ", pageCount=" + pageCount +
                ", pdfMargin='" + pdfMargin + '\'' +
                ", envelope='" + envelope + '\'' +
                ", file='" + file + '\'' +
                ", filingProof='" + filingProof + '\'' +
                ", lost_proof ='" + lostProof + '\'' +
                ", return_to_sender_proof='" + returnToSenderProof + '\'' +
                ", events='" + events + '\'' +
                ", price='" + price + '\'' +
                ", sheetCount='" + sheetCount + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sendDate=" + sendDate +
                ", metadata=" + metadata +
                ", canceled=" + canceled +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public RequestBuilder() {
        }

        public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public RequestBuilder setTo(String to) {
            params.put("to", to);
            return this;
        }

        public RequestBuilder setTo(Address.RequestBuilder to) {
            params.put("to", to.build());
            return this;
        }

        public RequestBuilder setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public RequestBuilder setFrom(Address.RequestBuilder from) {
            params.put("from", from.build());
            return this;
        }

        public RequestBuilder setColor(String color) {
            params.put("color", color);
            return this;
        }

        public RequestBuilder setSourceFile(String file, String sourceFileType) {

            if (lastSourceFileIndex > 1) {
                params.put("source_file_" + lastSourceFileIndex, file);
                params.put("source_file_" + lastSourceFileIndex + "_type", sourceFileType);
            } else {
                params.put("source_file", file);
                params.put("source_file_type", sourceFileType);
            }

            lastSourceFileIndex++;

            return this;
        }

        public RequestBuilder setSourceFile(java.io.File file, String sourceFileType) {
            isMultipart = true;

            if (lastSourceFileIndex > 1) {
                params.put("source_file_" + lastSourceFileIndex, file);
                params.put("source_file_" + lastSourceFileIndex + "_type", sourceFileType);
            } else {
                params.put("source_file", file);
                params.put("source_file_type", sourceFileType);
            }

            lastSourceFileIndex++;

            return this;
        }

        public RequestBuilder setVariables(Map<String, String> variables) {
            params.put("variables", variables);
            return this;
        }

        public RequestBuilder setBothSides(boolean bothSides) {
            params.put("both_sides", bothSides);
            return this;
        }

        public RequestBuilder setAddressPlacement(String addressPlacement) {
            params.put("address_placement", addressPlacement);
            return this;
        }

        public RequestBuilder setPostageType(String postageType) {
            params.put("postage_type", postageType);
            return this;
        }

        public RequestBuilder setPostageSpeed(String postageSpeed) {
            params.put("postage_speed", postageSpeed);
            return this;
        }

        public RequestBuilder setManageDeliveryProof(boolean manageDeliveryProof) {
            params.put("manage_delivery_proof", manageDeliveryProof);
            return this;
        }

        public RequestBuilder setPageCount(int pageCount) {
            params.put("page_count", pageCount);
            return this;
        }

        public RequestBuilder setEnvelope(String envelope) {
            params.put("envelope", envelope);
            return this;
        }

        public RequestBuilder setPdfMargin(int pdfMargin) {
            params.put("pdf_margin", pdfMargin);
            return this;
        }

        public RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public MysendingboxResponse<Letter> create()
                throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public MysendingboxResponse<Letter> create(RequestOptions options)
                throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, Letter.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Letter.class, options);
        }
    }

    public static MysendingboxResponse<Letter> retrieve(String id)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static MysendingboxResponse<Letter> retrieve(String id, RequestOptions options)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Letter.class,
                options);
    }

    public static MysendingboxResponse<LetterCollection> list()
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static MysendingboxResponse<LetterCollection> list(Map<String, Object> params)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static MysendingboxResponse<LetterCollection> list(RequestOptions options)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static MysendingboxResponse<LetterCollection> list(Map<String, Object> params, RequestOptions options)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, LetterCollection.class, options);
    }

    public static MysendingboxResponse<Letter> delete(String id)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static MysendingboxResponse<Letter> delete(String id, RequestOptions options)
            throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null,
                Letter.class, options);
    }

}
