package org.hopto.delow.springbootdemo.controller;

import lombok.Data;

import java.util.UUID;

@Data
public class HelloWorldResponse {

    private UUID id;

    private String message;

}
