package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.io.Serializable;

public enum TransactionState implements Serializable {
    INITIAL, PREPARE, COMMIT, ABORT
}
