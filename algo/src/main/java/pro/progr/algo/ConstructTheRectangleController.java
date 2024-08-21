package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/construct_the_rectangle")
public class ConstructTheRectangleController implements AlgoProblemInterface {
    @Override
    @GetMapping
    public String description() {
        return "A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:\n" +
                "\n" +
                "1.    The area of the rectangular web page you designed must equal to the given target area.\n" +
                " 2.   The width W should not be larger than the length L, which means L >= W.\n" +
                " 3.   The difference between length L and width W should be as small as possible.\n" +
                "\n" +
                "Return an array [L, W] where L and W are the length and width of the web page you designed in sequence." +
                " (https://leetcode.com/problems/construct-the-rectangle/description/)";
    }

    @GetMapping(params = "area")
    public String solution(@RequestParam Integer area) {
        for (int i = (int)Math.sqrt(area); i > 0; i--) {
            int otherField = area / i;
            if (i * otherField == area) {
                return Arrays.toString(new int[]{Math.max(i, otherField), Math.min(i, otherField)});
            }
        }

        return Arrays.toString(new int[]{area, 1});
    }
}
