    package leetcode.string;

    import java.util.Arrays;

    public class DetectCapital {
        public boolean checkLetterType(String word, boolean check){
            boolean match1 = Arrays.stream(word.split(""))
                    .allMatch(ch -> Character.isUpperCase(ch.charAt(0)));;
            boolean match2 = Arrays.stream(word.split(""))
                    .allMatch(ch -> Character.isLowerCase(ch.charAt(0)));;

            if(check){
                return match2 || match1;
            } else {
                return match2;
            }
        }
        public boolean detectCapitalUse(String word) {
            if(Character.isUpperCase(word.charAt(0))){
                return checkLetterType(word.substring(1),true);
            } else {
               return  checkLetterType(word.substring(1), false);
            }
        }
        public boolean detectCapitalUseOpt(String word) {
            if(word.chars().allMatch(Character::isUpperCase)){
                return true;
            } else if (word.chars().allMatch(Character::isLowerCase)) {
                return true;
            }
            return Character.isUpperCase(word.charAt(0)) && word.substring(1).chars().allMatch(Character::isLowerCase);
        }
        public static void main(String[] args) {
            DetectCapital detectCapital = new DetectCapital();
            String str = "FlaG"; //
            System.out.println(detectCapital.detectCapitalUse(str));
        }
    }
