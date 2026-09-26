package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private List<String> res;
    private int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.res = new ArrayList<>();
        dfs("", 0, 0);
        return res;

    }

    private void dfs(String s, int open, int close) {
        if(s.length() == 2*n){
            res.add(s);
            return;
        }
        if(open < n){
            dfs(s + "(", open + 1, close);
        }
        if(close < open){
            dfs(s + ")", open, close + 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
