import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Your task is to calculate the number of bit strings of length n.
 *
 * For example, if n=3, the correct answer is 8,
 * because the possible bit strings are 000, 001, 010, 011, 100, 101, 110, and 111.
 *
 * Input
 *
 * The only input line has an integer n.
 *
 * Output
 *
 * Print the result modulo 109+7.
 * */
public class BitStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        final int n = sc.nextInt();

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = (2 * result) % 1_000_000_007;
        }
        pw.print(result);
        pw.flush();
    }
}
