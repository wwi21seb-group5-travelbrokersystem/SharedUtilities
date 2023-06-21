package org.wwi21seb.vs.group5.TwoPhaseCommit;

import org.wwi21seb.vs.group5.UDP.UDPMessage;

public interface Participant {
    UDPMessage prepare(UDPMessage message);
    UDPMessage commit(UDPMessage message);
    UDPMessage abort(UDPMessage message);
}
