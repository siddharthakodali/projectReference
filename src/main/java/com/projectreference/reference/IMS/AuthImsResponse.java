package com.projectreference.reference.IMS;

import java.util.List;

public class AuthImsResponse {

    private boolean error;
    private String errorMessage;
    private List<AuthOutputParm> outputParm;

    public AuthImsResponse(boolean error, String errorMessage, List<AuthOutputParm> outputParm) {
        this.error = error;
        this.errorMessage = errorMessage;
        this.outputParm = outputParm;
    }

    public boolean isError() {
        return this.error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<AuthOutputParm> getOutputParm() {
        return outputParm;
    }

    public void setOutputParm(List<AuthOutputParm> outputParm) {
        this.outputParm = outputParm;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
