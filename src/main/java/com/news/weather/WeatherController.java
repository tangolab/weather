package com.news.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/weather/v1")
@RestController
public class WeatherController {

    private static Logger log = LoggerFactory.getLogger(WeatherController.class);

    @GetMapping("/today/{city}")
    public String home(@PathVariable("city") String city) throws InterruptedException {
        String ret = "Clear";
        log.info("Request received. Processing...");
        Long waitTime = 0L;
        switch (city) {
            case "New York":
                waitTime = 5000L;
                ret = "Cloudy";
                break;
            case "Philadelphia":
                waitTime = 1000L;
                ret = "Sunny";
                break;
            case "Montreal":
                waitTime = 2500L;
                ret = "Windy";
                break;
            default:
                ret = "Clear";
                break;
    }
        Thread.sleep(waitTime);    //Intentional delay
        log.info("Processing complete.");
        return ret;
    }
}