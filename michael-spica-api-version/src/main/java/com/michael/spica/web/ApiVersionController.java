package com.michael.spica.web;

import com.michael.spica.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michael on 2019/4/28.
 */
@RestController
@RequestMapping("/api")
public class ApiVersionController {

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "Hello World!";
    }

    @ApiVersion
    @GetMapping("/{version}/hello/world")
    public String helloWorld1() {
        return "Hello World ~~~~~~~~~~~ 111";
    }

    @ApiVersion(2)
    @GetMapping("/{version}/hello/world")
    public String helloWorld2() {
        return "Hello World ~~~~~~~~~~~ 222";
    }

    @ApiVersion(3)
    @GetMapping("/{version}/hello/world")
    public String helloWorld3() {
        return "Hello World ~~~~~~~~~~~ 333";
    }

    @ApiVersion(5)
    @GetMapping("/{version}/hello/world")
    public String helloWorld5() {
        return "Hello World ~~~~~~~~~~~ 555";
    }

    @ApiVersion(7)
    @GetMapping("/{version}/hello/world")
    public String helloWorld7() {
        return "Hello World ~~~~~~~~~~~ 777";
    }
}
