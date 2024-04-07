package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController implements ErrorController {

    @GetMapping("/")
    public String greeting() {
        return "Welcome to Diner Pancake House Merge";
    }
}
