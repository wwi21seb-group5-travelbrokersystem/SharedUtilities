package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionManager {

    private static final Map<String, TransactionContext> transactions = new ConcurrentHashMap<>();

    public static void prepare(String transactionId, TransactionContext context) {
        transactions.put(transactionId, context);
    }

    public static TransactionContext get(String transactionId) {
        return transactions.get(transactionId);
    }

    public static void commit(String transactionId) {
        TransactionContext context = transactions.remove(transactionId);

        if (context != null) {
            context.commit();
        }
    }

    public static void abort(String transactionId) {
        TransactionContext context = transactions.remove(transactionId);

        if (context != null) {
            context.abort();
        }
    }

}
