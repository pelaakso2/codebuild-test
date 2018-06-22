package com.codebuild.test.cbdemo.controller;

import com.codebuild.test.cbdemo.dto.http.response.HelloWorldResponse;
import com.codebuild.test.cbdemo.dto.http.response.MainResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @GetMapping("/world")
    @ResponseBody
    public MainResponse helloWorld(@RequestParam(name = "name", required = false) String name) {
        HelloWorldResponse response = Optional.ofNullable(name)
                .filter(n -> n.length() > 0)
                .map(n -> new HelloWorldResponse("Hello " + n))
                .orElseGet(() -> new HelloWorldResponse("Hello World"));

        return new MainResponse(HttpStatus.OK, response);
    }

}
