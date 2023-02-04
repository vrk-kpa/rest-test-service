package com.gofore.mygreatrestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HeartbeatController {

    @GetMapping(path = "/heartbeat", produces = "application/json")
    public String getHeartbeat() {
        return "Hello World!";
    }
}
