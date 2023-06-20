package org.wwi21seb.vs.group5.TwoPhaseCommit;

public interface ICoordinator {
    void prepare();
    boolean commit();
    void rollback();
}
