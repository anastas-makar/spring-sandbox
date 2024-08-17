package pro.progr.algo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jewels_stones")
public class JewelsStonesController implements AlgoProblemInterface {

    @Override
    @GetMapping
    public String description() {
        return "Передайте два параметра. Это две строки, каждая буква в которых обозначает название камня. Регистр имеет значение. " +
                "Jewels -- драгоценные камни, Stones -- любые камни, в том числе, драгоценные. " +
                "Нужно выяснить, сколько драгоценных камней (jewels) среди всех камней (stones).";
    }

    @GetMapping(params = {"jewels", "stones"})
    public String solution(@RequestParam String jewels, @RequestParam String stones) {
        var counter = 0;

        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    counter++;

                    break;
                }
            }
        }

        return String.valueOf(counter);
    }
}
