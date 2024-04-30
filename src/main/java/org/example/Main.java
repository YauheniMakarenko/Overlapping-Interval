package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {
    public static void main(String[] args) {
        List<Interval> list = List.of(
                new Interval(1, 2),
                new Interval(2, 5),
                new Interval(6, 8),
                new Interval(9, 11),
                new Interval(11, 14),
                new Interval(13, 22));

        System.out.println(execute(list));
    }

    public static List<Interval> execute(List<Interval> list) {
        LinkedList<Interval> result = new LinkedList<>();
        list.stream()
                .sorted(Comparator.comparingInt(Interval::getStart))
                .forEach(interval -> {
                    if (result.isEmpty() || result.getLast().getEnd() < interval.getStart()) {
                        result.add(interval);
                    } else {
                        result.getLast().setEnd(Math.max(result.getLast().getEnd(), interval.getEnd()));
                    }
                });
        return result;
    }
}

@Data
@AllArgsConstructor
class Interval {
    private int start;
    private int end;
}
