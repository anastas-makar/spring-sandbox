package pro.progr.algo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Решения простых задач с leetcode. Данные передаются в параметрах запроса без кавычек, например: " +
                "/jewels_stones?jewels=ESF&stones=dasfsf";
    }

}
