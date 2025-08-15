import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<String,Integer>();
        // diff between hashtable and hashmap, when to use what
            students.put("Surya", 88);         
            students.put("Nawneet", 18);         
            students.put("Rahul", 89);         
            students.put("Viki", 98); 
            
            System.out.println(students.keySet());

            for(String key : students.keySet())
            {
                System.out.println(key + ":" + students.get(key));
            }
    }
}
