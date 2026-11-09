package helloInterview.dsa.problems.twoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(char ch: s.toCharArray()){
            map.put(ch, s.lastIndexOf(ch));
        }

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if(i == end){
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        System.out.println(map);
        return list;
    }
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels.partitionLabels("eccbbbbdec"));
    }
}
