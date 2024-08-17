package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revert_char_array")
public class RevertCharArrayController implements AlgoProblemInterface {
    @Override
    @GetMapping
    public String description() {
        return "\n" +
                "Напишите функцию, которая преобразует строку в обратном порядке. Входная строка задается в виде массива таких символов.\n" +
                "\n" +
                "Вы должны сделать это, изменив входной массив на месте, добавив O(1) дополнительной памяти." +
                "\n" +
                "(параметр всё равно передаётся строкой)" +
                "\n" +
                "https://leetcode.com/problems/reverse-string/description/";
    }

    @GetMapping(params = "string")
    public String solution(@RequestParam String string) {
        //Привести к условию задачи
        var s = string.toCharArray();

        var start = 0;
        var end = s.length - 1;

        while (start < end) {
            var temp = s[start];

            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        return new String(s);
    }
}
