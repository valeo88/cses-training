import java.io.PrintWriter;
import java.util.Scanner;

/**
 * You have two coin piles containing a and b coins.
 * On each move, you can either remove one coin from the left pile and two coins from the right pile,
 * or two coins from the left pile and one coin from the right pile.
 *
 * Your task is to efficiently find out if you can empty both the piles.
 *
 * Input
 *
 * The first input line has an integer t: the number of tests.
 *
 * After this, there are t lines, each of which has two integers a and b: the numbers of coins in the piles.
 *
 * Output
 *
 * For each test, print "YES" if you can empty the piles and "NO" otherwise.
 * */
public class CoinPiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        /* steps = k + m;
        * a = 2k + m; b = k + 2m; solve and find k, m => conditions */
        final int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long k = 2 * a - b;
            long m = 2 * b - a;
            long k_3 = k % 3;
            long m_3 = m % 3;
            if (a != 0 && b != 0 && (k_3 == 0 && m_3 == 0)) {
                if (k / 3 >= 0 && m / 3 >= 0) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            } else if (a==0 && b==0) {
                pw.println("YES");
            } else if (a==0 && b!=0 || a!=0 && b==0) {
                pw.println("NO");
            } else {
                pw.println("NO");
            }
        }
        pw.flush();
    }
}
