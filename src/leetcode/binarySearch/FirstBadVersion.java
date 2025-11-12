package leetcode.binarySearch;

import java.util.*;
import java.util.stream.Collectors;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int firstBad = n;
        while (right >= left){
            int middle = left + (right - left)/2;
//            boolean result = isBadVersion(middle);
            boolean result = true;
            if(result){
                firstBad = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return firstBad;
    }
    public static void main(String[] args) {

    }
}
