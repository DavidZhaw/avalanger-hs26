package ch.zhaw.avalanger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/avalange")
public class AvalangeController {

    @GetMapping({ "", "/{country}" })
    public String getAllAvelanges(@PathVariable(required = false) String country,
            @RequestParam(required = false) String state) {
        return "No avelanges found for country: " + country + ", state: " + state;
    }
}
