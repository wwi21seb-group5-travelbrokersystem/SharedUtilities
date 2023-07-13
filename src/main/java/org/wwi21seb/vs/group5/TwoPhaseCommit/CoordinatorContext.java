package org.wwi21seb.vs.group5.TwoPhaseCommit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class CoordinatorContext implements Serializable {

    private UUID transactionId;
    private TransactionState transactionState;
    private Coordinator coordinator;
    private List<Participant> participants;
    private UUID bookingId;
    @JsonIgnore
    private transient CompletableFuture<Boolean> success;

    public CoordinatorContext() {

    }

    public CoordinatorContext(UUID transactionId, TransactionState transactionState, Coordinator coordinator, List<Participant> participants) {
        this.transactionId = transactionId;
        this.transactionState = transactionState;
        this.coordinator = coordinator;
        this.participants = participants;
    }

    public CoordinatorContext(UUID transactionId, TransactionState transactionState, Coordinator coordinator, List<Participant> participants, UUID bookingId) {
        this.transactionId = transactionId;
        this.transactionState = transactionState;
        this.coordinator = coordinator;
        this.participants = participants;
        this.bookingId = bookingId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    @JsonIgnore
    public CompletableFuture<Boolean> getSuccess() {
        return success;
    }

    public void setSuccess(CompletableFuture<Boolean> success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CoordinatorContext{" + "transactionId=" + transactionId + ", transactionState=" + transactionState + ", coordinator=" + coordinator + ", participants=" + participants + ", bookingId=" + bookingId + '}';
    }

}
