package org.hopto.delow.springbootdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("hello")
    ResponseEntity<HelloWorldResponse> getHello(@RequestParam(required = false, defaultValue = "world") String target) {
        HelloWorldResponse response = new HelloWorldResponse();
        response.setId(UUID.randomUUID());
        response.setMessage("Hello " + target + "!");
        return ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

}
