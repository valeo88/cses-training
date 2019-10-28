import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * A permutation of integers 1,2,…,n is called beautiful if there are no adjacent elements whose difference is 1.
 *
 * Given n, construct a beautiful permutation if such a permutation exists.
 *
 * Input
 *
 * The only input line contains an integer n.
 *
 * Output
 *
 * Print a beautiful permutation of integers 1,2,…,n.
 * If there are several solutions, you may print any of them.
 * If there are no solutions, print "NO SOLUTION".
 * */
public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();

        switch (n) {
            case 1:
                pw.print(n);
                break;
            case 2:
            case 3:
                pw.print("NO SOLUTION");
                break;
            default:
                int even = 2;
                while (even <= n) {
                    pw.print(even);
                    pw.print(' ');
                    even += 2;
                }
                int odd = 1;
                while (odd <= n) {
                    pw.print(odd);
                    pw.print(' ');
                    odd += 2;
                }
                break;
        }
        pw.flush();
    }
}
