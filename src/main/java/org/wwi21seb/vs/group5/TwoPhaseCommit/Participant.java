package org.wwi21seb.vs.group5.TwoPhaseCommit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Participant implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Name of the participant (e.g. HotelProvider)
    private String name;
    // URL of the participant: In our case the loopback address
    private InetAddress url;
    // Port of the participant: In our case the ports 5001 and 5002
    private int port;
    // The booking context of the participant, this stores the relevant
    // information regarding the booking
    private BookingContext bookingContext;
    // The vote of the participant, this is used to determine if the
    // participant is ready to commit or abort
    private Vote vote;
    // The done flag of the participant, this is used to determine if the
    // participant is finished with the commit or abort phase
    // If all participants are done the coordinator can finish the transaction
    // and delete the transaction context + the log
    private boolean done = false;
    // The future of the prepare phase, this is used to determine if the
    // participant is ready to commit or abort or if the participant is
    // not reachable. In this case this would timeout and the coordinator
    // would abort the transaction
    @JsonIgnore
    private transient CompletableFuture<Boolean> prepareFuture;

    public Participant(){}

    public Participant(String name, InetAddress url, int port) {
        this.name = name;
        this.url = url;
        this.port = port;
        this.vote = Vote.PENDING;
    }

    public String getName() {
        return name;
    }

    public InetAddress getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public BookingContext getBookingContext() {
        return bookingContext;
    }

    public void setBookingId(UUID bookingId) {
        BookingContext newBookingContext = bookingContext;
        newBookingContext.setBookingId(bookingId);
        this.bookingContext = newBookingContext;
    }

    public void setBookingContext(BookingContext bookingContext) {
        this.bookingContext = bookingContext;
    }

    @JsonIgnore
    public CompletableFuture<Boolean> getPrepareFuture() {
        return prepareFuture;
    }

    public void setPrepareFuture(CompletableFuture<Boolean> prepareFuture) {
        this.prepareFuture = prepareFuture;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return "Participant{" + "name=" + name + ", url=" + url + ", port=" + port + ", vote=" + vote + '}';
    }

}
