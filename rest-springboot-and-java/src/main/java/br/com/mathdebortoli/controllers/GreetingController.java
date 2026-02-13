package br.com.mathdebortoli.controllers;

import br.com.mathdebortoli.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Salve jovem, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "pedro") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));

    }
}
