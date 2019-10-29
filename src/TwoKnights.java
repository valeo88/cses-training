import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Your task is to count for k=1,2,…,n the number of ways two knights
 * can be placed on a k×k chessboard so that they do not attack each other.
 *
 * Input
 *
 * The only input line contains an integer n.
 *
 * Output
 *
 * Print n integers: the results.
 * */
public class TwoKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            pw.println(calcDisposition(i));
        }
        pw.flush();
    }

    private static long calcDisposition(long i) {
        if (i == 1) return 0;
        return i * i * (i*i - 1) / 2 - 8 * (i-2)*(i-1) / 2;
    }
}
