package com.mschmidl.helloservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    private ApplicationContext applicationContext;

    private int port;

    @GetMapping("/greeting")
    String home() {
        return String.format("Hello from port '%s'!", port);
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        port = event.getWebServer().getPort();
    }
}
