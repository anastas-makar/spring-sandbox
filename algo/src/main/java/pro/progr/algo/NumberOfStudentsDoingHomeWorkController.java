package pro.progr.algo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number_of_students_doing_homework")
public class NumberOfStudentsDoingHomeWorkController implements AlgoProblemInterface {

    private final Gson gson = (new GsonBuilder()).create();

    @Override
    @GetMapping
    public String description() {
        return "Даны два целочисленных массива startTime и EndTime и задано целочисленное время запроса.\n" +
                "\n" +
                "i-й ученик начал выполнять домашнее задание в момент startTime[i] и закончил его в момент EndTime[i].\n" +
                "\n" +
                "Возвращает количество учеников, выполнявших домашнее задание в момент запроса. " +
                "Более формально, верните количество учащихся, " +
                "для которых время выполнения запроса находится " +
                "в интервале [startTime[i], EndTime[i]] включительно. " +
                "Уловия: " +
                "\n" +
                "    startTime.length == endTime.length\n" +
                "    1 <= startTime.length <= 100\n" +
                "    1 <= startTime[i] <= endTime[i] <= 1000\n" +
                "    1 <= queryTime <= 1000\n" +
                "(https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/description/) " +
                "Массивы передаются в виде [1,3,4,5], но в url-encoded формате " +
                "Наприме: http://localhost:8080/number_of_students_doing_homework?startTimeArray=%5B1%2C2%2C3%2C4%5D&endTimeArray=%5B5%2C3%2C3%2C4%5D&queryTime=4";
    }

    @GetMapping(params = {"startTimeArray", "endTimeArray", "queryTime"})
    public Integer solution(
            @RequestParam String startTimeArray,
            @RequestParam String endTimeArray,
            @RequestParam Integer queryTime
    ) {
        var startTime = gson.fromJson(startTimeArray, Integer[].class);
        var endTime = gson.fromJson(endTimeArray, Integer[].class);

        var counter = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime
            && endTime[i] >= queryTime) {
                counter++;
            }
        }

        return counter;

    }
}
