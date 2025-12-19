package cses;

public class MissingNo {
    public int missingNo(int[] arr){
        for (int i = 1; i < arr.length + 1; i++) {
            if (arr[i - 1] != i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
        MissingNo missingNo = new MissingNo();
        System.out.println(missingNo.missingNo(arr));
    }
}
