package helloInterview.dsa.problems.hashPrefix;

import java.util.*;

public class GroupAnagrams {
    private boolean checkAnagram(String s1, String s2){
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch: s2.toCharArray()){
            freq[ch - 'a']--;
        }
        for(int num : freq){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if(visited[i]){
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if(!visited[j] && checkAnagram(strs[i], strs[j])){
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            res.add(group);
        }
        return res;
    }
    // computeIfAbsent:
    //if (!map.containsKey(key)) {
    //    map.put(key, new ArrayList<>());
    //}
    //
    //return map.get(key);
    public List<List<String>> groupAnagramsOpt(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        // [[eat, tea], [tan, nat],[bat]]
        System.out.println(groupAnagrams.groupAnagramsOpt(strs));
    }
}
