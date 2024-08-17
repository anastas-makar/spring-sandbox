package pro.progr.algo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/arrays_equal_by_reversing")
public class ArraysEqualByReversingController implements AlgoProblemInterface {
    private final Gson gson = (new GsonBuilder()).create();

    @Override
    @GetMapping
    public String description() {
        return "Вам даны два целочисленных массива одинаковой длины target и arr. " +
                "За один шаг вы можете выбрать любой непустой подмассив arr и изменить его. " +
                "Вам разрешено выполнить любое количество шагов. " +
                "Верните значение true, если вы можете сделать значение равно target, " +
                "или значение false в противном случае. " +
                "Массивы передаются в виде [1,3,4,5] " +
                "но работает только url-encoded формат: ?target=%5B1%2C2%2C3%5D&arr=%5B2%2C1%2C3%5D " +
                "(https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/description/)";
    }

    @GetMapping(params = {"target", "arr"})
    public String solution(@RequestParam String target, @RequestParam String arr) {
        //Все массивы можно отсортировать пузырьком
        //Это значит, что все массивы можно отсортировать, меняя элементы местами
        //Осталось проверить, получим ли мы два одинаковых массива после сортировки
        var targetSorted = gson.fromJson(target, String[].class);
        Arrays.sort(targetSorted);
        var otherSorted = gson.fromJson(arr, String[].class);
        Arrays.sort(otherSorted);

        return String.valueOf(Arrays.equals(targetSorted, otherSorted));
    }
}
