package leetcode.string;

public class RotationIndexDiff {
    public int rotationDiff(String s, String t){
        String res = s + s;
        return res.indexOf(t.charAt(0));
    };
    public static void main(String[] args) {
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        RotationIndexDiff rotationIndexDiff = new RotationIndexDiff();
        System.out.println(rotationIndexDiff.rotationDiff(str1, str2));
    }
}
