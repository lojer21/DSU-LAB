import java.util.Scanner;

class prg1
{
    static void unipolarNRZ(int[] data)
    {
        System.out.println("Unipolar NRZ Encoding: ");
        for(int bit: data)
        {
            if (bit == 1)
                System.out.print("1");
            else
                System.out.print("0");
            } 
        System.out.println();
    }
    
    static void polarNRZ(int[] data)
    {
        System.out.println("Polar NRZ Encoding: ");
        for(int bit: data)
        {
            if (bit == 1)
                System.out.print("1");
            else
                System.out.print("-1");
            } 
        System.out.println();
    }
    
    static void manchester(int[] data)
    {
        System.out.println("Manchester Encoding: ");
        for(int bit: data)
        {
            if (bit == 1)
                System.out.print("+1, -1\t");
            else
                System.out.print("-1, +1\t");
            } 
        System.out.println();
    }
    
    static void differential_Manchester(int[] data)
    {
        System.out.println("Differential Manchester Encoding: ");
        int lastTransaction = 1;

        for(int bit: data)
        {
            if (bit == 1)
                System.out.print("-1, +1\t");
            else
            {
                System.out.print(lastTransaction == 1 ? "-1, +1" : "+1, -1");
                lastTransaction = -lastTransaction;
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {   
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of bits int the data: ");
        int n = sc.nextInt();
        
        int[] data = new int[n];
        System.out.print("Enter the binary data bits (0s and 1s): ");
        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();
        
        System.out.println("Select your choice of convertion");
        System.out.println("1. Unipolar NRZ");
        System.out.println("2. Polar NRZ");
        System.out.println("3. Manchester");
        System.out.println("4. Differential Manchester");
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                unipolarNRZ(data);
                break;
            case 2:
                polarNRZ(data);
                break;
            case 3:
                manchester(data);
                break;
            case 4:
                differential_Manchester(data);
                break;
            default:
                System.out.println("Invalid option. Enter between 1-4.");
        }
        sc.close();
    }

}
