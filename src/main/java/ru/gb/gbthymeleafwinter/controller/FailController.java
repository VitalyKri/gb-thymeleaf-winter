package ru.gb.gbthymeleafwinter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fail")
public class FailController {

    @GetMapping
    public String fail(){
        return "failureAuthorize";
    }
}
