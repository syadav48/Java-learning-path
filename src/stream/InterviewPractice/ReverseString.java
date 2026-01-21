package stream.InterviewPractice;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String str = "java";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            stringBuilder.append(str.charAt(i));
        }
        System.out.println(stringBuilder);

        Optional<Employee> max = DataFactory.employees().stream().max(
                Comparator.comparing(x -> x.getSalary())
        );
        System.out.println(max.get());
    }
}
