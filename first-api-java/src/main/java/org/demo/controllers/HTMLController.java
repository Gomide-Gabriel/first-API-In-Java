package org.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HTMLController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
