package org.wwi21seb.vs.group5.TwoPhaseCommit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class TransactionContext {

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("state")
    private TransactionState state;

    @JsonProperty("participants")
    private Map<String, Vote> participants;

    @JsonProperty("data")
    private String coordinator;

    public TransactionContext(String transactionId, Map<String, Vote> participants, String coordinator) {
        this.transactionId = transactionId;
        this.state = TransactionState.INITIAL;
        this.participants = participants;
        this.coordinator = coordinator;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionState getState() {
        return state;
    }

    public Map<String, Vote> getParticipants() {
        return participants;
    }

    public List<Vote> getVotes() {
        return List.copyOf(participants.values());
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public void vote(String participantId, Vote vote) {
        participants.put(participantId, vote);
    }

    public boolean allVotesReceived() {
        return participants.values().stream().allMatch(vote -> vote != Vote.INITIAL);
    }

}

