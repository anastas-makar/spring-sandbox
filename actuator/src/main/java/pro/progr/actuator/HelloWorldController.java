package pro.progr.actuator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@ModelAttribute NameDTO nameDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new Greeting(counter.incrementAndGet(), "ERROR");
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, nameDTO.getName()));
    }
}
