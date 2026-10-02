package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;

public class ValidStrings {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTrackVS(n, path, res);
        return res;
    }

    private void backTrackVS(int n, StringBuilder path, List<String> res) {
        if(path.length() == n){
            res.add(path.toString());
            return;
        }
        if(path.length() == 0 || path.charAt(path.length() - 1) != '0'){
            path.append('0');
            backTrackVS(n, path, res);
            path.deleteCharAt(path.length() -1);
        }

            path.append('1');
            backTrackVS(n, path, res);
            path.deleteCharAt(path.length() -1);

    }

    public static void main(String[] args) {
        ValidStrings validStrings = new ValidStrings();
        int n = 3;
        System.out.println(validStrings.validStrings(n));
    }
}
