package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ParticipantContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private UUID transactionId;
    private TransactionState transactionState;
    private Coordinator coordinator;
    private List<Participant> participants;
    private transient CompletableFuture<Boolean> commitFuture;

    public ParticipantContext() {

    }

    public ParticipantContext(CoordinatorContext coordinatorContext) {
        this.transactionId = coordinatorContext.getTransactionId();
        this.transactionState = coordinatorContext.getTransactionState();
        this.coordinator = coordinatorContext.getCoordinator();
        this.participants = coordinatorContext.getParticipants();
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

    public void setBookingIdForParticipant(UUID bookingId, String participantName) {
        for (Participant participant : participants) {
            if (participant.getName().equals(participantName)) {
                participant.setBookingId(bookingId);
            }
        }
    }
}
