package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AvailabilityRequest(@JsonProperty("startDate") String startDate, @JsonProperty("endDate") String endDate,
                                  @JsonProperty("numberOfPersons") int numberOfPersons) {

    public AvailabilityRequest(String startDate, String endDate, int numberOfPersons) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfPersons = numberOfPersons;
    }

    @Override
    public String startDate() {
        return startDate;
    }

    @Override
    public String endDate() {
        return endDate;
    }

    @Override
    public int numberOfPersons() {
        return numberOfPersons;
    }
}
