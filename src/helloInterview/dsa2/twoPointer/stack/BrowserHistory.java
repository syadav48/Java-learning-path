package helloInterview.dsa2.twoPointer.stack;

import java.util.Iterator;
import java.util.Stack;

public class BrowserHistory {
    Stack<String> stack = new Stack<>();

    public BrowserHistory(String homepage) {
        stack.push(homepage);
    }

    public void visit(String url) {
        stack.push(url);
    }

    public String back(int steps) {
        if(steps > stack.size()){
            return stack.get(0);
        }
        String s = "";
        for (int i = 0; i < steps; i++){
          s = stack.get(stack.size() - i - 1);
        }
        return s;
    }

    public String forward(int steps) {
        String s = "";
        for (int i = 0; i < steps; i++){
            s = stack.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        browserHistory.back(1);
        browserHistory.back(1);
        browserHistory.forward(1);
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        browserHistory.back(2);
        System.out.println(browserHistory.stack);
        System.out.println(browserHistory.back(7));

    }
}
