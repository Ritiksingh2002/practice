package com.aims.Formulary.Schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {
    @Scheduled(fixedRate = 2000L)
    void someJob(){
        System.out.println(new Date());
    }
}
