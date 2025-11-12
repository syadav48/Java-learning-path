package leetcode.binarySearch;

public class GuessGame {
    public int guessNumber(int n) {
       int left = 0;
       int right = n - 1;
       while (right >= left){
           int middle = left + (right - left)/2;
//           int res = guess(middle);
           int res = 10;
           if(res == 0){
               return middle;
           } else if (res == 1) {
               left = middle + 1;
           } else {
               right = middle - 1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame();
        guessGame.guessNumber(10);
    }
}
