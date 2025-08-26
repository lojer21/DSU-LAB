// 20-08-2025
// 1. Take two numbers as input from the user and print the greater one.
import java.util.*;
class Greater
{
  public static void main(String[] aya)
  {
        Scanner lo = new Scanner(System.in);
        System.out.print("Enter Num1: ");
        int a = lo.nextInt();
        System.out.print("Enter Num2: ");
        int b = lo.nextInt();
        if (a == b) 
            System.out.println("Both are equal.");
        else
        {
            if (a > b)
                System.out.println(a + " is Greater than " + b);
            else
                System.out.println(b + " is Greater than " + a);
        }
    }

}
