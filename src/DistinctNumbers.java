import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * You are given a list of n integers, and your task is to calculate the number of distinct values in the list.
 *
 * Input
 *
 * The first input line has an integer n: the number of values.
 *
 * The second line has n integers x1,x2,…,xn.
 *
 * Output
 *
 * Print one integers: the number of distinct values.
 *
 * Constraints
 *
 * 1≤n≤2⋅105
 * 1≤xi≤109
 * */
public class DistinctNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        Set<Integer> s = new HashSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            s.add(sc.nextInt());
        }

        pw.println(s.size());
        pw.flush();
    }

}
