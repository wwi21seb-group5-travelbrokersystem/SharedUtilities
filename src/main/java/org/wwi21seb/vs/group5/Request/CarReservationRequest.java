package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record CarReservationRequest(
        @JsonProperty("car_id")
        UUID carID,
        @JsonProperty("start_date")
        String startDate,
        @JsonProperty("end_date")
        String endDate
) { }
