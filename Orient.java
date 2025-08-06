class Calculator 
{
    int n1 = 5;
    public int add(int num1, int num2)
    {
        System.out.println("Adding the two values");
        return num1 + num2;
    }  
    public int add(int num1, int num2, int num3)
    {
        System.out.println("Adding the three values");
        return num1 + num2 + num3;
    } 
    public double add(double num1, int num2)
    {
        return num1 + num2;
    }  
    
}

 class Computer {
    public void PlayMusic()
    {
        System.out.println("Playing Music");
    }

    public String getPen(int cost)
    {
        if (cost >= 10) {
            return "Pen";
        } else{
            return "Nothing";
        }
    }
    
}


public class Orient {
    public static void main(String[] args) 
    {
        int num1 = 9;
        int num2 = 11;

        Calculator calc = new Calculator();
        int result = calc.add(num1, num2);
        System.out.println(result);

        Computer obj = new Computer();
        obj.PlayMusic();

        String str = obj.getPen(7);
        System.out.println(str);

    }
}
// Object Oriented Programming
//Object - Properties and Behaviours

// Class

