package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class HotelReservationRequest {
    @JsonProperty("room_id")
    private UUID roomID;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("number_of_persons")
    private int numberOfPersons;

    public HotelReservationRequest(
            @JsonProperty("room_id") UUID roomID,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate,
            @JsonProperty("number_of_persons") int numberOfPersons) {
        this.roomID = roomID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPersons = numberOfPersons;
    }

    public UUID getRoomID() {
        return roomID;
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
}
