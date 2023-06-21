package org.wwi21seb.vs.group5.UDP;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UDPMessage(@JsonProperty("operation") Operation operation,
                         @JsonProperty("transaction_id") UUID transactionId, @JsonProperty("sender") String sender,
                         @JsonProperty("data") Object data) {

    public UDPMessage(Operation operation, UUID transactionId, String sender, Object data) {
        this.operation = operation;
        this.transactionId = transactionId;
        this.sender = sender;
        this.data = data;
    }

    @Override
    public Operation operation() {
        return operation;
    }

    @Override
    public UUID transactionId() {
        return transactionId;
    }

    @Override
    public String sender() {
        return sender;
    }

    @Override
    public Object data() {
        return data;
    }

}
