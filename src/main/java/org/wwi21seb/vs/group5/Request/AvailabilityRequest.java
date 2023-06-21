package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailabilityRequest {
        @JsonProperty("startDate")
        private String startDate;
        @JsonProperty("endDate")
        private String endDate;
        @JsonProperty("numberOfPersons")
        private int numberOfPersons;

        @JsonCreator
        public AvailabilityRequest(
                @JsonProperty("startDate") String startDate,
                @JsonProperty("endDate") String endDate,
                @JsonProperty("numberOfPersons") int numberOfPersons
        ) {
                this.startDate = startDate;
                this.endDate = endDate;
                this.numberOfPersons = numberOfPersons;
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

