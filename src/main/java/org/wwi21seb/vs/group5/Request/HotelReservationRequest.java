package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record HotelReservationRequest (
    @JsonProperty("room_id")
     UUID roomID,
    @JsonProperty("start_date")
     String startDate,
    @JsonProperty("end_date")
     String endDate,
    @JsonProperty("number_of_persons")
     int numberOfPersons
) { }
