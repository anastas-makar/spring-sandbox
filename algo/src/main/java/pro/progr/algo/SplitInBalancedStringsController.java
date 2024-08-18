package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/split_in_balanced_strings")
public class SplitInBalancedStringsController implements AlgoProblemInterface {
    @Override
    @GetMapping
    public String description() {
        return "Сбалансированные строки - это те, которые содержат равное количество символов 'L' и 'R'.\n" +
                "\n" +
                "Получив сбалансированную строку s, разделите ее на некоторое количество подстрок таким образом, чтобы:\n" +
                "\n" +
                "    Каждая подстрока была сбалансированной.\n" +
                "\n" +
                "Верните максимальное количество сбалансированных строк, которое вы можете получить.\n" +
                "\n" +
                "Ограничения:\n" +
                "\n" +
                "    2 <= s.длина <= 1000\n" +
                "    s[i] - это либо \"L\", либо \"R\".\n" +
                "    s - сбалансированная строка." +
                " (https://leetcode.com/problems/split-a-string-in-balanced-strings/description/)";
    }

    /**
     * Важно понимать, что строка "сбалансирована",
     * т.е. количество R в ней равно количеству L
     * Из этого следует, что если в какой-то её подстроке
     * количество R равно количеству L, то и в оставшейся части
     * будет так же.
     *
     * Также: если мы двигались от начала строки и насчитали равное количество R и L,
     * а затем, не сбрасывая счётчик, продолжили двигаться и снова дошли до точки, когда R == L,
     * мы можем быть уверены, что мы можем разбить строку на подстроки в этих местах и получить
     * везде сбалансированные подстроки.
     *
     * На этом можно основать алгоритм.
     *
     * @param balancedString сбалансированная строка
     * @return максимальное количество сбалансированных подстрок, на которое можно её порезать
     */
    @GetMapping(params = {"balancedString"})
    public Integer solution(@RequestParam String balancedString) {
        var substrCounter = 0;

        var rCounter = 0;
        var lCounter = 0;

        for (int i = 0; i < balancedString.length(); i++) {
            if (balancedString.charAt(i) == 'R') {
                rCounter++;
            } else {
                lCounter++;
            }

            if (rCounter == lCounter) {
                substrCounter++;
            }
        }

        return substrCounter;

    }
}
