import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] addEach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
        }
        return arr;
    }

    public double findMax(int[] arr) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public double findMin(int[] arr) {
        double min = Double.POSITIVE_INFINITY;
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public void reverse(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public int[] sort(int[] arr) {
         Arrays.sort(arr);
        return arr;
    }
    public int findElem(int[] arr) {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, 4);
    }
    public List<Integer> removeEven(List<Integer> arr) {
        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                arr.remove(i);
            }
        }
        return arr;
    }

}

public class ArrTest {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = { 1, 2, 3, 4, 5 };
        int [] arrnums = {4, 8, 1, 9, 3};
        List<String> fruits = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        System.out.println(obj.removeEven(integers));
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Pine");
        fruits.add("Jack");
        fruits.add("Litchi");
        fruits.set(2, "Orange");
        System.out.println(Arrays.toString(obj.addEach(nums)));
        System.out.println(obj.findMax(nums));
        System.out.println(obj.findMin(nums));
        System.out.println(obj.findElem(arrnums));
        obj.reverse(nums);
        System.out.println(Arrays.toString(obj.sort(arrnums)));
        System.out.println(fruits);
        System.out.println();
    }
}
