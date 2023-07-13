package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ReservationRequest {
    @JsonProperty("resource_id")
    private UUID resourceId;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("number_of_persons")
    private int numberOfPersons;

    public ReservationRequest(
            @JsonProperty("resource_id") UUID resourceId,
            @JsonProperty("start_date") String startDate,
            @JsonProperty("end_date") String endDate,
            @JsonProperty("number_of_persons") int numberOfPersons) {
        this.resourceId = resourceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPersons = numberOfPersons;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public UUID getResourceId() {
        return resourceId;
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
