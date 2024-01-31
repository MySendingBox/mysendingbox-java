package com.mysendingbox.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysendingbox.exception.APIException;
import com.mysendingbox.exception.AuthenticationException;
import com.mysendingbox.exception.InvalidRequestException;
import com.mysendingbox.exception.RateLimitException;
import com.mysendingbox.net.MysendingboxResponse;
import com.mysendingbox.net.RequestOptions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterElectronic extends Letter {

    @JsonProperty
    private final String content;
    @JsonProperty
    private final ZonedDateTime termOfUseValidation;
    @JsonProperty
    private final com.mysendingbox.model.File downloadProof;
    @JsonProperty
    private final com.mysendingbox.model.File rejectionProof;
    @JsonProperty
    private final com.mysendingbox.model.File negligenceProof;

    @JsonCreator
    public LetterElectronic(
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
            @JsonProperty("object") final String object,
            @JsonProperty("content") final String content,
            @JsonProperty("term_of_use_validation") final ZonedDateTime termOfUseValidation,
            @JsonProperty("downloadProof") final com.mysendingbox.model.File downloadProof,
            @JsonProperty("rejectionProof") final com.mysendingbox.model.File rejectionProof,
            @JsonProperty("negligenceProof") final com.mysendingbox.model.File negligenceProof) {
        super(_id,
                channel,
                description,
                mode,
                to,
                from,
                "none",
                false,
                "none",
                sourceFileType,
                sourceFile,
                postageType,
                "none",
                manageDeliveryProof,
                0,
                0,
                pdfMargin,
                "none",
                file,
                filingProof,
                lostProof,
                returnToSenderProof,
                events,
                price,
                trackingNumber,
                variables,
                expectedDeliveryDate,
                createdAt,
                updatedAt,
                sendDate,
                metadata,
                canceled,
                object);

        this.content = content;
        this.termOfUseValidation = termOfUseValidation;
        this.downloadProof = downloadProof;
        this.rejectionProof = rejectionProof;
        this.negligenceProof = negligenceProof;

        lastSourceFileIndex = 1;
    }

    public String getContent() {
        return content;
    }

    public ZonedDateTime getTermOfUseValidation() {
        return termOfUseValidation;
    }

    public com.mysendingbox.model.File getDownloadProof() {
        return downloadProof;
    }

    public com.mysendingbox.model.File getRejectionProof() {
        return rejectionProof;
    }

    public com.mysendingbox.model.File getNegligenceProof() {
        return negligenceProof;
    }

    @Override
    public String toString() {
        return "LetterElectronic{" +
                "_id='" + _id + '\'' +
                ", channel ='" + channel + '\'' +
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
                ", content ='" + content + '\'' +
                ", termOfUseValidation ='" + termOfUseValidation + '\'' +
                ", downloadProof ='" + downloadProof + '\'' +
                ", rejectionProof ='" + rejectionProof + '\'' +
                ", negligenceProof ='" + negligenceProof + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private final Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public RequestBuilder() {
        }

        public LetterElectronic.RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public LetterElectronic.RequestBuilder setTo(String to) {
            params.put("to", to);
            return this;
        }

        public LetterElectronic.RequestBuilder setTo(Address.RequestBuilder to) {
            params.put("to", to.build());
            return this;
        }

        public LetterElectronic.RequestBuilder setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public LetterElectronic.RequestBuilder setFrom(Address.RequestBuilder from) {
            params.put("from", from.build());
            return this;
        }

        public LetterElectronic.RequestBuilder setSourceFile(String file, String sourceFileType) {

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

        public LetterElectronic.RequestBuilder setSourceFile(java.io.File file, String sourceFileType) {
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

        public LetterElectronic.RequestBuilder setVariables(Map<String, String> variables) {
            params.put("variables", variables);
            return this;
        }

        public LetterElectronic.RequestBuilder setPostageType(String postageType) {
            params.put("postage_type", postageType);
            return this;
        }

        public LetterElectronic.RequestBuilder setManageDeliveryProof(boolean manageDeliveryProof) {
            params.put("manage_delivery_proof", manageDeliveryProof);
            return this;
        }

        public LetterElectronic.RequestBuilder setPdfMargin(int pdfMargin) {
            params.put("pdf_margin", pdfMargin);
            return this;
        }

        public LetterElectronic.RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public LetterElectronic.RequestBuilder setContent(String content) {
            params.put("content", content);
            return this;
        }

        public LetterElectronic.RequestBuilder setMetadata(ZonedDateTime termOfUseValidation) {
            params.put("term_of_use_validation", termOfUseValidation);
            return this;
        }

        public MysendingboxResponse<LetterElectronic> create()
                throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public MysendingboxResponse<LetterElectronic> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return request(
                    RequestMethod.POST,
                    isMultipart ? RequestType.MULTIPART : RequestType.NORMAL,
                    RESOURCE + "/electronic",
                    params,
                    LetterElectronic.class,
                    options
            );
        }
    }

}
