package com.coding.springrest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    // add code for /hello endpoint
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world!";
    }

}
