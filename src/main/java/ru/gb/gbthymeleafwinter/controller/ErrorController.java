package ru.gb.gbthymeleafwinter.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors")
public class ErrorController {


    @GetMapping("/failureAuthorize")
    public String fail() {
        return "failureAuthorize";

    }


}
