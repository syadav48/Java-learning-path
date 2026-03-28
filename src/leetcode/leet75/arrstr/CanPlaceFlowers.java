package leetcode.leet75.arrstr;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if(i > 0 && i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
                n--;
            } else if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 ) {
                flowerbed[i] = 1;
                n--;
            } else if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 ) {
                flowerbed[i] = 1;
                n--;
            }

        }
        return n <= 0;
    }
   public static void main(String[] args) {
        CanPlaceFlowers can = new CanPlaceFlowers();
        int[] flowerbed = {1,0,0,0,0,1}; // 0,0,1
        int n = 2;
       System.out.println(can.canPlaceFlowers(flowerbed, n));
    }
}
