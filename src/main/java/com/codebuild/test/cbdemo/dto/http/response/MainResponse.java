package com.codebuild.test.cbdemo.dto.http.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainResponse {
    private HttpStatus status;
    private Object data;

    public MainResponse(HttpStatus status) {
        this.status = status;
    }

    public MainResponse(HttpStatus status, Object data) {
        this.status = status;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @JsonProperty
    public int getStatusCode() {
        return status.value();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
