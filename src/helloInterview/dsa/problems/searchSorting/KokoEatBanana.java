package helloInterview.dsa.problems.searchSorting;

public class KokoEatBanana {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 0;
            for(int pile: piles){
                right = Math.max(right, pile);
            }
            int ans = right;
            while (left <= right){
                int mid = left + (right - left)/2;
                long hours = hoursNeeded(piles, mid);
                if(hours <= h){
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    private long hoursNeeded(int[] piles, int speed){
        long hours = 0;
        for(int pile: piles){
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
    public static void main(String[] args) {
        KokoEatBanana kokoEatBanana = new KokoEatBanana();
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        // 4 -> 3/4 - 0, 6/4 - 1, 7/4 - 1, 11/4 - 2
        System.out.println(kokoEatBanana.minEatingSpeed(piles, h));
    }
}
