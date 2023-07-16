package org.wwi21seb.vs.group5.UDP;

public enum Operation {
    // Prepare phase of the two-phase commit protocol
    PREPARE,
    // Commit phase of the two-phase commit protocol
    COMMIT,
    // Abort phase of the two-phase commit protocol
    ABORT,
    // Get the available rentals
    GET_AVAILABILITY,
    // Get the decided result of a transaction
    RESULT,
    // Get the bookings of a customer
    GET_BOOKINGS
}
