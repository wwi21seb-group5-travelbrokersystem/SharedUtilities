package org.wwi21seb.vs.group5.UDP;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UDPMessage {

    @JsonProperty("operation")
    private Operation operation;
    @JsonProperty("transaction_id")
    private UUID transactionId;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("data")
    private String data;

    // i hate jackson
    public UDPMessage() {
    }

    public UDPMessage(Operation operation, UUID transactionId, String sender, String data) {
        this.operation = operation;
        this.transactionId = transactionId;
        this.sender = sender;
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public String getSender() {
        return sender;
    }

    public String getData() {
        return data;
    }
}
