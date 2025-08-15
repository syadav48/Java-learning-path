import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student
{
    int age;
    String name;

    
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
    
    
}

public class Comparatora {   
    public static void main(String[] args) {
        // Comparator<Integer> com = new Comparator<Integer>() {
        //     // changing the way it sorts the value
        //     public int compare(Integer i, Integer j) {
        //         if (i % 10 > j % 10)
        //             return 1;
        //         else 
        //             return -1;

        //     }
        // };

          Comparator<Student> com = new Comparator<Student>() {
            // changing the way it sorts the value - if you want to specify which logic you want to sort - use comparator
            public int compare(Student i, Student j) {
                if (i.age > j.age)
                    return 1;
                else 
                    return -1;

            }
        };
        //Comparator <Student> com = (i, j) -> i.age > j.age ? 1 : -1; -> Lamda Expression
        List<Student> studs = new ArrayList<>();
        // studs.add(43);
        // studs.add(56);
        // studs.add(93);
        // studs.add(03);

        studs.add(new Student(23, "Surya"));
        studs.add(new Student(34, "Nawneet"));
        studs.add(new Student(21, "Rahul"));
        studs.add(new Student(24, "Nitish"));
        Collections.sort(studs, com);
        for(Student s: studs)
        {
            System.out.println(s);
        }
        System.out.println(studs);
    }
}
