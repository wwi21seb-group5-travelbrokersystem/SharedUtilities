package org.wwi21seb.vs.group5.TwoPhaseCommit;

import java.awt.print.Book;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BookingContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private UUID resourceId;
    private UUID bookingId;
    private String startDate;
    private String endDate;
    private int numberOfPersons;

    private BookingContext() {}

    public BookingContext(UUID resourceId, String startDate, String endDate, int numberOfPersons) {
        this.resourceId = resourceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPersons = numberOfPersons;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingContext{" +
                "resourceId=" + resourceId +
                ", bookingId=" + bookingId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", numberOfPersons=" + numberOfPersons +
                '}';
    }
}
