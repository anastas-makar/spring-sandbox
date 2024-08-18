package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/max_consecutive_chars")
public class CountMaxConsecutiveCharsController implements AlgoProblemInterface {

    @Override
    @GetMapping
    public String description() {
        return "[Power] строки - это максимальная длина непустой подстроки, содержащей только один уникальный символ.\n" +
                "\n" +
                "Если задана строка s, верните [power] строки s." +
                "\n" +
                "    1 <= s.length <= 500\n" +
                "    s consists of only lowercase English letters.\n" +
                "(https://leetcode.com/problems/consecutive-characters/description/)";
    }

    @GetMapping(params = {"string"})
    public Integer solution(@RequestParam String string) {
        if (string.isEmpty()) {
            return 0;
        }

        //Начинаем с первого символа
        var maxPower = 1;
        var currentPower = 1;
        var currentChar = string.charAt(0);

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == currentChar) {
                currentPower++;
                maxPower = Math.max(maxPower, currentPower);
            } else {
                currentPower = 1;
                currentChar = string.charAt(i);
            }
        }

        return maxPower;
    }
}
