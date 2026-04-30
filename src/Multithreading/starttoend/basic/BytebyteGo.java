package Multithreading.starttoend.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BytebyteGo {
    public static Map<String, Integer> longestPalindrome(String[] words){
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(String str: words){
            builder.append(str);
        }
        String s = builder.toString();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = new String(chars);
        String s2 = new StringBuilder(s1).reverse().toString();
        StringBuilder builder1 =  new StringBuilder();
        StringBuilder builder2 =  new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(i % 2 == 0){
                builder1.append(s1.charAt(i));
            } else {

                builder2.append(s2.charAt(i));
            }
        }
        StringBuilder append = builder1.append(builder2);
        map.put(append.toString(), append.length());
        return map;
    }
    // websec
    // @Configurat Websecury http.csrd, ausa, auth, has,auth -> jwt ->
    // React - controle
    // rereder ->
    // lld -> Input ->
    // High Traffic -> Rate limitter, Load Balance -> Scla
    // Request -> controller (/v1) AOP -> inferface -> checkTheLimit -> Checklimit -> Request -> Map -> Local Time -> 3 sec of -> Requ count++ 10> throw -> Rate Limit Exceedded
    // SELECT *, SALARY FROM EMPLOYEE
    // ORDER BY SALARY DESC
    // LIMIT 3
    // OFFSET 2



    public static void main(String[] args) {
        String [] words = {"lc", "cl", "gg"}; // -> longest palindrome,and the length glcclg ccllgg clgglc // cgllgc
        System.out.println(BytebyteGo.longestPalindrome(words));
    }
}
