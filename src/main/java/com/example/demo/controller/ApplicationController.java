package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApplicationController {

    @RequestMapping("/example")
    private ResponseEntity<String> getExample() {
        log.info("/example Endpoint was called");
        return ResponseEntity.status(200).body("Example");

    }
}
