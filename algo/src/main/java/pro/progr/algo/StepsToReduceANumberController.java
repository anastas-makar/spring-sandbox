package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/steps_to_reduce_number")
public class StepsToReduceANumberController implements AlgoProblemInterface {

    @Override
    @GetMapping
    public String description() {
        return "Дано целое число num. " +
                "Верните количество шагов, чтобы уменьшить его до нуля.\n" +
                "\n" +
                "За один шаг, если текущее число четное, вы должны разделить его на 2, " +
                "в противном случае вы должны вычесть из него 1. " +
                "(https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/)";
    }

    @GetMapping(params = {"number"})
    public Integer solution(@RequestParam Integer number) {

        var stepCount = 0;

        while (number > 0) {
            if (number % 2 > 0) {
                number -= 1;
            } else {
                number /= 2;
            }

            stepCount++;
        }

        return stepCount;
    }
}
