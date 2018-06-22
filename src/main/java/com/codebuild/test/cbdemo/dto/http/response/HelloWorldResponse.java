package com.codebuild.test.cbdemo.dto.http.response;

public class HelloWorldResponse {
    private String message;

    public HelloWorldResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
