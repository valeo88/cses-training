import java.io.PrintWriter;
import java.util.Scanner;

/**A number spiral is an infinite grid whose upper-left square has number 1.
 *  Here are the first five layers of the spiral:

 Your task is to find out the number in row y and column x.

 Input

 The first input line contains an integer t: the number of tests.

 After this, there are t lines, each containing integers y and x.

 Output

 For each test, print the number in row y and column x.
 *
 * */
public class NumberSpiral {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            pw.println(findNumber(y, x));
        }
        pw.flush();
    }

    private static long findNumber(long row, long column) {
        if (row == 1 && column == 1) {
            return 1;
        }
        long max = Math.max(row, column);
        long prevMax = (max - 1) * (max - 1);
        long curMax = max * max;
        if (row >= column) {
            if (row % 2 == 0) {
                return curMax - (column - 1);
            } else {
                return prevMax + column;
            }
        } else {
            if (column % 2 == 0) {
                return prevMax + row;
            } else {
                return curMax - (row - 1);
            }
        }
    }
}
