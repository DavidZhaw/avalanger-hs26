package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/avalange")
public class AvalangeController {

    @GetMapping("")
    public String getAllAvelanges() {
        return "No avelanges found..";
    } 
}
