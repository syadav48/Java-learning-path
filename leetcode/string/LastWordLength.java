
class Abc 
{
    public void show()
    {
        System.out.println("In abc show");
    }
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        String[] part = trimmed.split(" ");
        int lastwordlength = part[part.length - 1].length();
        return lastwordlength;
    }

}

public class LastWordLength {
    public static void main(String[] args) {
        Abc obj = new Abc();
        System.out.println(obj.lengthOfLastWord("Hello World"));
        System.out.println(obj.lengthOfLastWord("   fly me   to   the moon  "));
    }
}


