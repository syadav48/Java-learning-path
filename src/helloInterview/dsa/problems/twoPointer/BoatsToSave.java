package helloInterview.dsa.problems.twoPointer;

import java.util.Arrays;

public class BoatsToSave {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        while (left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }
    public static void main(String[] args) {
        BoatsToSave boats = new BoatsToSave();
        int[] people = {3,2,1,2,1,1}; //1,1,1,2,2,3
        System.out.println(boats.numRescueBoats(people, 3));
    }
}
