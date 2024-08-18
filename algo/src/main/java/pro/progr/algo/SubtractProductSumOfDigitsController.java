package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/substr_product_sum")
public class SubtractProductSumOfDigitsController implements AlgoProblemInterface {
    @Override
    @GetMapping
    public String description() {
        return "Получите целое число n " +
                "и верните разницу между произведением его цифр и суммой его цифр. " +
                "(https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/)";
    }

    @GetMapping(params = {"number"})
    public Integer solution(@RequestParam Integer number) {
        if (number == 0) {
            return 0;
        }

        var product = 1;
        var sum = 0;

        while (number > 0) {
            var digit = number % 10;

            product *= digit;
            sum += digit;

            number /= 10;
        }

        return product - sum;
    }
}
