package com.codebuild.test.cbdemo.dto.http.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;

public class HelloWorldResponseTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testSerialize() throws JsonProcessingException, JSONException {
        HelloWorldResponse helloWorldResponse = new HelloWorldResponse("hello");
        MainResponse response = new MainResponse(HttpStatus.OK, helloWorldResponse);

        String json = objectMapper.writeValueAsString(response);

        String expected = "{\"status\": \"OK\", \"statusCode\": 200, \"data\": {\"message\": \"hello\"}}";
        JSONAssert.assertEquals(expected, json, false);
    }
}