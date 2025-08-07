class Student {
    int rollNo;
    String name;
    int marks;
}
    

public class Arraya {

    public static void main(String[] args) {
        int num[] = { 3, 5, 9, 4 };
        int nums[] = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        System.out.println(num[1]);
        System.out.println(nums[0]);
        // multidimension

        int multi[][] = new int[3][4];
        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                multi[i][j] = (int) (Math.random() * 10);
                System.out.print(multi[i][j] + " ");
            }
            System.out.println("");
        }
        // enhancedforloop
        for (int i[] : multi) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Jagged Array
        int jagged[][] = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[5];
        jagged[2] = new int[4];

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = (int) (Math.random() * 10);
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }

        // enhanced one

        for (int[] i : jagged) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Array of Objects
        Student s1 = new Student();
        s1.rollNo = 1;
        s1.name = "Suryoday";
        s1.marks = 39;
        Student s2 = new Student();
        s2.rollNo = 1;
        s2.name = "Naman";
        s2.marks = 90;
        Student s3 = new Student();
        s3.rollNo = 1;
        s3.name = "Azeem";
        s3.marks = 93;

        Student students [] = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        for (int i = 0; i <students.length; i++) {
            System.out.println(students[i].name + " " + students[i].marks);
        }


    }
}
