package leetcode.string;

import java.util.*;

public class CountLargestGroup {
    public int generateKey(int n){
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int key = generateKey(i);
            if(hashMap.containsKey(key)){
                hashMap.get(key).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(key, list);
            }

        }
        int size = hashMap.entrySet().stream().max(Comparator.comparing(
                x -> x.getValue().size()
        )).get().getValue().size();
        System.out.println(hashMap + " size" + size);
        for(Map.Entry<Integer, List<Integer>> map: hashMap.entrySet()){
            if(map.getValue().size() == size){
                res++;
            }
        }
        return res;

    }

    public int countLargestGroupOpt(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int key = generateKey(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = Collections.max(map.values());

        int count = 0;
        for (int val : map.values()) {
            if (val == max) count++;
        }

        return count;

    }

    public static void main(String[] args) {
        CountLargestGroup countLargestGroup = new CountLargestGroup();
        System.out.println(countLargestGroup.countLargestGroup(24));
    }
}
