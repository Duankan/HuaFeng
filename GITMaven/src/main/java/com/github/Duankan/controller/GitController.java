package com.github.Duankan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/git")
public class GitController {

    @RequestMapping("/one")
    public String one(){
        return "vv";
    }
}
