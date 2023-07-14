package org.wwi21seb.vs.group5.Request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResult {

    @JsonProperty("success")
    private boolean success;

    @JsonCreator
    public TransactionResult(
            @JsonProperty("success") boolean success
    ) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
