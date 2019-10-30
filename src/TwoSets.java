import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  Your task is to divide the numbers 1,2,…,n into two sets of equal sum.
 *
 * Input
 *
 * The only input line contains an integer n.
 *
 * Output
 *
 * Print "YES", if the division is possible, and "NO" otherwise.
 *
 * After this, if the division is possible, print an example of how to create the sets.
 * First, print the number of elements in the first set followed by the elements themselves in a separate line,
 * and then, print the second set in a similar way.
 * */
public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        final long n = sc.nextInt();
        final long totalSum = n * (n + 1) / 2;

        if (totalSum % 2 == 0) {
            pw.println("YES");
            final long dest = totalSum / 2;
            Set<Long> set1 = new HashSet<>();
            long sum1 = 0;
            Set<Long> set2 = new HashSet<>();
            for (long i = n; i >= 1; i--) {
                if (sum1 + i <= dest) {
                    sum1 += i;
                    set1.add(i);
                } else {
                    set2.add(i);
                }
            }
            pw.println(set1.size());
            for (long i : set1) {
                pw.print(i);
                pw.print(' ');
            }
            pw.print('\n');
            pw.println(set2.size());
            for (long i : set2) {
                pw.print(i);
                pw.print(' ');
            }
            pw.print('\n');
        } else {
            pw.println("NO");
        }
        pw.flush();
    }
}
