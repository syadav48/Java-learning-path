package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;

public class GetHappyString {
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder paths = new StringBuilder();
        backTrackHappyString(n, paths, res);
        System.out.println(res);
        return k > res.size() ? "" : res.get(k - 1);
    }

    private void backTrackHappyString(int n, StringBuilder paths, List<String> res) {
        if(paths.length() == n){
            System.out.println(paths);
            res.add(paths.toString());
            return;
        }
        if(paths.isEmpty() || paths.charAt(paths.length() - 1) != 'a'){
            paths.append('a');
            backTrackHappyString(n, paths, res);
            paths.deleteCharAt(paths.length() - 1);
        }
        if(paths.isEmpty() || paths.charAt(paths.length() - 1) != 'b'){
            paths.append('b');
            backTrackHappyString(n, paths, res);
            paths.deleteCharAt(paths.length() - 1);
        }

        if(paths.isEmpty() || paths.charAt(paths.length() - 1) != 'c'){
            paths.append('c');
            backTrackHappyString(n, paths, res);
            paths.deleteCharAt(paths.length() - 1);
        }
    }

    public static void main(String[] args) {
        GetHappyString getHappyString = new GetHappyString();
        System.out.println(getHappyString.getHappyString(3, 9));
    }
}
