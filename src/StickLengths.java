import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * There are n sticks with some lengths.
 * Your task is to modify the sticks so that each stick has the same length.
 *
 * You can either lengthen and shorten each stick.
 * Both operations cost x where x is the difference between the new and original length.
 *
 * What is the minimum total cost?
 *
 * Input
 *
 * The first input line contains an integer n: the number of sticks.
 * Then there are n integers: p1,p2,…,pn: the lengths of the sticks.
 *
 * Output
 *
 * Print one integer: the minimum total cost.
 * */
public class StickLengths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        // middle of arrays is optimum, it's easy to prove by shift 1 element left and then right
        // if we go n / 2 + 1 in left part we have more +diff, than -diff in right
        // if we go n / 2 - 1 in right part we have more -diff, than +diff in left
        long middle = arr[n / 2];

        long totalCost = 0;
        for (int x : arr) {
            totalCost += Math.abs(middle - x);
        }

        System.out.println(totalCost);

    }
}
