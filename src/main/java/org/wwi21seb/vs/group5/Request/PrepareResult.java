package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PrepareResult {

    @JsonProperty("transaction_id")
    private UUID transactionId;

    @JsonProperty("resource_id")
    private UUID resourceId;

    @JsonCreator
    public PrepareResult(
            @JsonProperty("transaction_id") UUID transactionId,
            @JsonProperty("ressource_id") UUID resourceId) {
        this.transactionId = transactionId;
        this.resourceId = resourceId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public UUID getResourceId() {
        return resourceId;
    }

}
