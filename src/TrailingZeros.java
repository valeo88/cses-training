import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Your task is to calculate the number of trailing zeros in the factorial n!.
 *
 * For example, 20!=2432902008176640000 and it has 4 trailing zeros.
 *
 * Input
 *
 * The only input line has an integer n.
 *
 * Output
 *
 * Print the number of trailing zeros in n!.
 * */
public class TrailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();

        int tz = 0;
        while (n >= 1) {
            tz += n /= 5;
        }
        pw.print(tz);
        pw.flush();
    }
}
