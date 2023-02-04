package com.gofore.mygreatrestservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class HeartbeatController {

    private final static String APP_NAME = "MyGreatRestService";
    private final static String APP_VERSION = "1.0.0";

    @GetMapping(path = "/heartbeat", produces = "application/json")
    public ResponseEntity<Heartbeat> getHeartbeat() {
        return ResponseEntity.ok(Heartbeat.builder().appName(APP_NAME).appVersion(APP_VERSION).systemTime(LocalDateTime.now()).build());
    }

    @GetMapping(path = "/hello", produces = "application/json")
    public String getHello() {
        return "Hello World!";
    }
}
