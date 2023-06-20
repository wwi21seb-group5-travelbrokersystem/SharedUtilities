package org.wwi21seb.vs.group5.TwoPhaseCommit;

public interface TransactionContext {
    void commit();
    void abort();
}

