package org.wwi21seb.vs.group5.UDP;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * The UDPMessage is a class used to standardize the communication between the
 * different services. It contains the operation (e.g. PREPARE, COMMIT, ...),
 * the transaction id, the sender and the data needed to perform the operation.
 */
public class UDPMessage {

    @JsonProperty("operation")
    private Operation operation;
    @JsonProperty("transaction_id")
    private UUID transactionId;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("data")
    private String data;

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

    @Override
    public String toString() {
        return "UDPMessage{" +
                "operation=" + operation +
                ", transactionId=" + transactionId +
                ", sender='" + sender + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
