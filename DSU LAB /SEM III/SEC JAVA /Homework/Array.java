// 20-08-2025
// Create an array of size 10. Add squares of the numbers to this array. 

class SquaresArray {
    public static void main(String[] aya) {
        int[] squares = new int[10];  // array of size 10

        for (int i = 0; i < squares.length; i++) {
            squares[i] = (i + 1) * (i + 1); 
        }
      
        System.out.println("Squares of numbers :");
        for (int i = 0; i < squares.length; i++) {
            System.out.println( i + " = " + squares[i]);
        }
    }
}
