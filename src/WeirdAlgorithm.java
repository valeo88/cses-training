import java.io.PrintWriter;
import java.util.Scanner;

/** Consider an algorithm that takes as input a positive integer n.
 *  If n is even, the algorithm divides it by two, and if n is odd, the algorithm multiplies it by three and adds one.
 *  The algorithm repeats this, until n is one. For example, the sequence for n=3 is as follows:
    3→10→5→16→8→4→2→1

 Your task is to simulate the execution of the algorithm for a given value of n.

 Input

 The only input line contains an integer n.

 Output

 Print a line that contains all values of n during the algorithm.*/
public class WeirdAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        long n = scanner.nextLong();

        printWriter.print(n);
        while (n!=1) {
            printWriter.print(' ');
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            printWriter.print(n);
        }
        printWriter.flush();
    }
}
