package stream.InterviewPractice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckAnagram {
    public boolean isAnagram(String s1, String s2){

        Map<String, Long> collect1 = Arrays.stream(s1.split("")).collect(Collectors.groupingBy(
                x -> x, Collectors.counting()
        ));
        Map<String, Long> collect2 = Arrays.stream(s2.split("")).collect(Collectors.groupingBy(
                x -> x, Collectors.counting()
        ));
        System.out.println(collect2);
        System.out.println(collect1);
        for (Map.Entry<String, Long> collect: collect1.entrySet()){
            if(!collect2.keySet().contains(collect.getKey())){
                return false;
            } else if (!collect2.get(collect.getKey()).equals(collect1.get(collect.getKey()))) {
                return false;
            }
        }
        return true;

    }
    public boolean isOptimalAnagram(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Long> collect1 = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        x -> x, Collectors.counting()
                ));
        Map<Character, Long> collect2 = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        x -> x, Collectors.counting()
                ));
        return collect1.equals(collect2);
    }
    public boolean isAnagramMost(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        CheckAnagram checkAnagram = new CheckAnagram();
        System.out.println(checkAnagram.isOptimalAnagram(s1, s2));

    }
}
