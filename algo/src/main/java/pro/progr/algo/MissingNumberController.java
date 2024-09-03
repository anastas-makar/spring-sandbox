package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/missing_number")
public class MissingNumberController implements AlgoProblemInterface {

    @Override
    @GetMapping
    public String description() {
        return "Given an array nums containing n distinct numbers " +
                "in the range [0, n], return the only number in the range " +
                "that is missing from the array. " +
                "(https://leetcode.com/problems/missing-number/description/)";
    }

    @GetMapping(params = {"nums"})
    public Integer solution(@RequestParam List<Integer> nums) {
        Integer[] numsArray = nums.toArray(new Integer[0]);
        Arrays.sort(numsArray);

        var expected = 0;

        for (int i = 0; i < numsArray.length; i++) {
            if(numsArray[i] > expected) {
                return expected;
            }

            expected++;
        }

        return expected;
    }
}
