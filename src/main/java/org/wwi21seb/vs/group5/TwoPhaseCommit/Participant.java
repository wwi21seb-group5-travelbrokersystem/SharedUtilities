package org.wwi21seb.vs.group5.TwoPhaseCommit;

import org.wwi21seb.vs.group5.UDP.UDPMessage;

public interface Participant {
    void prepare(UDPMessage message);
    void commit(UDPMessage message);
    void abort(UDPMessage message);
}
