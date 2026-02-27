package br.com.mathdebortoli.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/teste")
    public String testLog(){
        logger.info("This is info Log!");
        logger.warn("This is warn Log!");
        logger.trace("This is trace Log!");
        logger.trace("This is debug Log!");
        logger.error("This is error Log!");

        return "Logs Started Successfully!";
    }
}
