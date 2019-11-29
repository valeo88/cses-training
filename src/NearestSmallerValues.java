import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Given an array of n integers, your task is to find for each array position the nearest position to its left having a smaller value.
 *
 * Input
 *
 * The first input line has an integer n: the size of the array.
 *
 * The second line has n integers x1,x2,…,xn: the array values.
 *
 * Output
 *
 * Print n integers: for each array position the nearest position with a smaller value. If there is no such position, print 0.
 * */
public class NearestSmallerValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Pair> u = new ArrayDeque<>();
        for (int i = 0; i < values.length; i++) {
            int x = 0;
            int v = values[i];
            while (!u.isEmpty()) {
                Pair p = u.getLast();
                x = p.position;
                if (p.val < v) break;
                u.removeLast();
            }
            if (u.isEmpty()) x = 0;
            System.out.print(x);
            System.out.print(" ");
            u.addLast(new Pair(v, i + 1));
        }



    }

    private static class Pair {
        int val;
        int position;

        public Pair(int val, int position) {
            this.val = val;
            this.position = position;
        }
    }
}
