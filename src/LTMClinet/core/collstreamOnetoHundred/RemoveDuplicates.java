package LTMClinet.core.collstreamOnetoHundred;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public String removeDuplictes(String str){
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
            if(builder.indexOf(String.valueOf(ch)) == -1){
                builder.append(ch);
            }
        }
        Map<Character, Long> collect = Arrays.stream(str.split("")).collect(
                Collectors.groupingBy(
                        x -> x.charAt(0),
                        Collectors.counting()
                )
        );
        System.out.println(map);
        System.out.println(collect);
        return builder.toString();

    }
    public boolean checkAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
    public boolean sortChar(String s){
        Map<Character, Long> collect = s.chars().mapToObj(x -> (char) x).collect(
                Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                )
        );
        System.out.println(collect);
        LinkedHashMap<Character, Long> collect1 = collect.entrySet().stream().sorted(
                Comparator.comparing(x -> x.getValue(), Comparator.reverseOrder())
        ).collect(Collectors.toMap(
                x -> x.getKey(),
                x -> x.getValue(),
                (e1, e2) -> e1,
                LinkedHashMap::new
        ));
        System.out.println(collect1);
        return true;
    }
    public int longestSubString(String s){
        int max = Integer.MIN_VALUE;
        int first = 0;
        int second = 1;
        while (second < s.length()){
           if(s.charAt(first) != s.charAt(second)){
               first++;
               second++;
           } else {
               second++;
           }
           max = Math.max(max, second - first);

        }
        return max;

    }
    public int secondHighestNo(int[] nums){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > max){
                secondMax = max;
                max = num;
            }else if(num > secondMax && num != max){
                secondMax = num;
            }
        }
        return secondMax;
    }
    public int firstDuplicate(int[] nums){
        LinkedHashSet<Integer> seen = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(!seen.add(num)){
                System.out.println(num);
                seen.add(num);
                list.add(num);
            }
        }
        System.out.println(seen);

        System.out.println(list);
        return 5;
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String str = "aabbc";
        String s1 = "listen";
        String s2 = "silent";
        String s3 = "aaabbhhjjkkkiiiielmddss"; // elmd
        int[] nums = {1,3,4,2,2,8,4,5,6};
        System.out.println(removeDuplicates.removeDuplictes(str));
        System.out.println(removeDuplicates.checkAnagram(s1, s2));
        System.out.println(removeDuplicates.sortChar(s3));
        System.out.println(removeDuplicates.longestSubString(s3));
        System.out.println(removeDuplicates.secondHighestNo(nums));
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.size());
        System.out.println(removeDuplicates.firstDuplicate(nums));



    }
}
