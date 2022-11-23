package com.demo.fe.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.netty.http.server.HttpServerRequest;

@RestController
public class TestController {

    public static final String TOKEN_HEADER = "Authorization";

    @GetMapping("/boards/fail")
    public void doFail(){
        throw new RuntimeException("faild");
    }

}
