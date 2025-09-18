//CRC 
//  18/09/2025
import java.util.*;
// 1. Importing Required Classes
public class CRC {

    // 2. Main Method
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        // --- Input Data ---
        System.out.print("Enter the size of the data array: ");
        int dataSize = scan.nextInt();
        int[] data = new int[dataSize];

        System.out.println("Enter data bits: ");
        for (int i = 0; i < dataSize; i++) {
            data[i] = scan.nextInt();
        }

        // --- Input Divisor (Generator Polynomial) ---
        System.out.print("Enter the size of the divisor array: ");
        int divisorSize = scan.nextInt();
        int[] divisor = new int[divisorSize];

        System.out.println("Enter divisor bits: ");
        for (int i = 0; i < divisorSize; i++) {
            divisor[i] = scan.nextInt();
        }

        // 3. CRC Calculation
        int[] remainder = divideDataWithDivisor(data, divisor);

        System.out.print("Generated CRC bits: ");
        for (int i = 0; i < remainder.length - 1; i++) {
            System.out.print(remainder[i]);
        }
        System.out.println();

        // Append CRC to data → Codeword
        System.out.print("Codeword to be sent: ");
        for (int bit : data) {
            System.out.print(bit);
        }
        for (int i = 0; i < remainder.length - 1; i++) {
            System.out.print(remainder[i]);
        }
        System.out.println();

        // 4. Simulating Transmission
        int[] sentData = new int[data.length + remainder.length - 1];
        System.out.println("Enter the received bits: ");
        for (int i = 0; i < sentData.length; i++) {
            sentData[i] = scan.nextInt();
        }

        // Receiver side check
        receiveData(sentData, divisor);

        scan.close();
    }

    // 5. Helper Methods
    // CRC Calculation (Polynomial Division)
    static int[] divideDataWithDivisor(int[] oldData, int[] divisor) {
        int[] remainder = new int[divisor.length];
        int[] data = new int[oldData.length + divisor.length];

        // Copy input data into new array
        System.arraycopy(oldData, 0, data, 0, oldData.length);
        System.arraycopy(data, 0, remainder, 0, divisor.length);

        // Perform division (XOR)
        for (int i = 0; i < oldData.length; i++) {
            if (remainder[0] == 1) {
                for (int j = 1; j < divisor.length; j++) {
                    remainder[j - 1] = exorOperation(remainder[j], divisor[j]);
                }
            } else {
                for (int j = 1; j < divisor.length; j++) {
                    remainder[j - 1] = exorOperation(remainder[j], 0);
                }
            }
            remainder[divisor.length - 1] = data[i + divisor.length];
        }
        return remainder;
    }

    // XOR operation
    static int exorOperation(int x, int y) {
        return (x == y) ? 0 : 1;
    }

    // Receiver check
    static void receiveData(int[] data, int[] divisor) {
        int[] remainder = divideDataWithDivisor(data, divisor);
        for (int bit : remainder) {
            if (bit != 0) {
                System.out.println("Corrupted data received...");
                return;
            }
        }
        System.out.println("Data received without any error.");
    }
}
