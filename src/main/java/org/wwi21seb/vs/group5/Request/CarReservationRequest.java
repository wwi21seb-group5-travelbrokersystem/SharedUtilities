package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CarReservationRequest {
    @JsonProperty("car_id")
    private UUID carID;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;

    @JsonCreator
    public CarReservationRequest(
            @JsonProperty("car_id") UUID carID,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate) {
        this.carID = carID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getCarID() {
        return carID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
