package leetcode.counting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MostCommon {
    public static String mostCommonWord(String paragraph, String[] banned) {

        List<String> list = Arrays.stream(paragraph.split(", ")).map(String::toLowerCase).toList();
        System.out.println(list);
        return "ball";
    }
    public static void main(String[] args) {
        String[] banned = {"hit"};
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));
    }
}
