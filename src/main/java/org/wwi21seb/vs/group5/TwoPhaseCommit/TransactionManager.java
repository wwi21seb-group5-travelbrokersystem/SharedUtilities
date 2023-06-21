package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TransactionManager {

    private Map<String, TransactionContext> activeTransactions;

    public TransactionManager() {
        this.activeTransactions = new HashMap<>();
    }

    public TransactionContext createTransaction(List<String> participants) {
        String transactionId = UUID.randomUUID().toString(); // generate unique transaction id
        Map<String, Vote> participantStates = participants.stream()
                .collect(Collectors.toMap(key -> key, val -> Vote.INITIAL));
        TransactionContext transaction = new TransactionContext(transactionId, participantStates, "TRAVEL_BROKER");
        activeTransactions.put(transactionId, transaction);
        return transaction;
    }

    public TransactionContext getTransaction(String transactionId) {
        return activeTransactions.get(transactionId);
    }

    public void prepare(TransactionContext transaction, String participantId, Vote vote) {
        transaction.vote(participantId, vote);

        if (transaction.allVotesReceived()) {
            if (transaction.getVotes().contains(Vote.ABORT)) {
                transaction.setState(TransactionState.ABORT);
            } else {
                transaction.setState(TransactionState.READY_TO_COMMIT);
            }
        }
    }

    public void commit(TransactionContext transaction) {
        if (transaction.getState() == TransactionState.READY_TO_COMMIT) {
            transaction.setState(TransactionState.COMMIT);
            activeTransactions.remove(transaction.getTransactionId());
            // TODO: Notify participants to commit transaction
        } else {
            throw new IllegalStateException("Cannot commit transaction that is not READY_TO_COMMIT");
        }
    }

    public void abort(TransactionContext transaction) {
        transaction.setState(TransactionState.ABORT);
        activeTransactions.remove(transaction.getTransactionId());
        // TODO: Notify participants to abort transaction
    }

}
