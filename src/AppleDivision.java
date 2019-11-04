import java.io.PrintWriter;
import java.util.Scanner;

/**
 * There are n apples with known weights.
 * Your task is to divide the apples into two groups so that the difference between the weights of the groups is minimal.
 *
 * Input
 *
 * The first input line has an integer n: the number of apples.
 *
 * The next line has n integers p1,p2,…,pn: the weight of each apple.
 *
 * Output
 *
 * Print one integer: the minimum difference between the weights of the groups.
 *
 * Constraints
 *
 * 1≤n≤20
 * 1≤pi≤10^9
 * */
public class AppleDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long min_diff = Long.MAX_VALUE;
        // iterate over all sets
        for (int b = 0; b < (1 << n); b++) {
            min_diff = Math.min(min_diff, calcDiff(b, arr));
            if (min_diff == 0) break;
        }

        pw.println(min_diff);
        pw.flush();

    }

    /** Using bit mask to find elements in array */
    private static long calcDiff(int b, long[] arr) {
        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < arr.length; i++) {
            int bm = b & (1<<i);
            if ((bm >> i) == 1) {
                s1 += arr[i];
            } else {
                s2 += arr[i];
            }
        }
        return Math.abs(s1 - s2);
    }
}
