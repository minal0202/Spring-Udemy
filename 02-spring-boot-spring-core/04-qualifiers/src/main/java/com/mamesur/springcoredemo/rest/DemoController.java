package com.mamesur.springcoredemo.rest;

import com.mamesur.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.myCoach = coach;
    }

    @GetMapping("/dailyWorkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
