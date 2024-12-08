package com.mamesur.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    DemoController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
