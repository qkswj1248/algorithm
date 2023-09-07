package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("han", 1));
        students.add(new Student("ban", 2));
        students.add(new Student("jan", 3));

        // collect 를 map 으로 바꾸기
        Map<String, Integer> result = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student::getNumber
                ));

        // collect 를 이름만 가져와서 map 으로 바꾼다음 String 으로 만들기
        String result2 = students.stream().map(
                Student::getName
        ).collect(Collectors.joining(","));

        System.out.println(result.getClass().getName());
        System.out.println(result);
        System.out.println("--------");
        System.out.println(result2);

    }
}
