package leetcode.binarySearch;

import java.util.Arrays;

public class GreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] != target && letters[i] - target > 0){
                diff = Math.min(diff, letters[i] - target);
            }
        }
        return diff == Integer.MAX_VALUE ? letters[0] : (char) (target + diff);
    };

    //optimizedNextGreatestLetter
    public char optimizedNextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low + " " + " low ");
        // circular condition handled here
        return letters[low % letters.length];
    }


    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        GreaterThanTarget greaterThanTarget = new GreaterThanTarget();
        System.out.println(greaterThanTarget.optimizedNextGreatestLetter(letters, target));
    }
}
