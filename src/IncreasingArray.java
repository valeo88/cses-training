import java.io.PrintWriter;
import java.util.Scanner;

/**
 * You are given an array of n integers.
 * You want to modify the array so that it is increasing,
 * i.e., every element is at least as large as the previous element.
 *
 * On each turn, you may increase the value of any element by one.
 * What is the minimum number of turns required?
 *
 * Input
 *
 * The first input line contains an integer n: the size of the array.
 *
 * Then, the second line contains n integers x1,x2,…,xn: the contents of the array.
 *
 * Output
 *
 * Print the minimum number of turns.
 * */
public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        long turns = 0;
        for(int i = 1; i < n; i++) {
            if (x[i] < x[i-1]) {
                turns += x[i-1] - x[i];
                x[i] = x[i-1];
            }
        }

        pw.print(turns);
        pw.flush();
    }
}
