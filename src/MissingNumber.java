import java.io.PrintWriter;
import java.util.*;

/**
 * You are given all numbers between 1,2,…,n except one. Your task is to find the missing number.
 *
 * Input
 *
 * The first input line contains an integer n.
 *
 * The second line contains n−1 numbers. Each number is distinct and between 1 and n (inclusive).
 *
 * Output
 *
 * Print the missing number.
 * */
public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            set.add(scanner.nextInt());
        }

        for(int i = 1; i <=n ; i++) {
            if (!set.contains(i)) {
                printWriter.print(i);
                printWriter.flush();
                break;
            }
        }
    }
}
