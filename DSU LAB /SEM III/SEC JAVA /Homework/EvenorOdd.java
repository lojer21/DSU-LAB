// 21-08-2025
// Take one number and print whether it is even or odd.
import java.util.*;
class EvenorOdd
{
    public static void main(String[] aya) 
  {
        Scanner lo = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = lo.nextInt();

        if (num % 2 == 0) 
        {
            System.out.println(num + " is Even");
        } 
        else 
        {
            System.out.println(num + " is Odd");
        }
    }
}
