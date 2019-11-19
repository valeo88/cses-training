import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * You are given an array of n integers, and your task is to find three values (at distinct positions) whose sum is x.
 *
 * Input
 *
 * The first input line has two integers n and x: the array size and the target sum.
 * The second line has n integers a1,a2,…,an: the array values.
 *
 * Output
 *
 * Print three integers: the positions of the values.
 * If there are several solutions, you may print any of them.
 * If there are no solutions, print IMPOSSIBLE.
 *
 * */
public class SumThreeValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final int x = Integer.parseInt(st.nextToken());
        final double thX = x / 3.;

        boolean allLessTh = true;
        boolean allMoreTh = true;

        List<Pair> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            a.add(new Pair(val, i));
            if (val >= thX) allLessTh = false;
            if (val <= thX) allMoreTh = false;
        }

        if (allLessTh || allMoreTh) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        a.sort(Pair::compareTo);

        // for all elements using solution for sum of two values
        for (int k = 0; k < a.size(); k++) {
            int x2 = x - a.get(k).value;
            if (x2 <= 0) continue;
            int i = 0;
            int j = a.size() - 1;
            while (i < j) {
                if (i == k) i++;
                if (j == k) j--;
                if (a.get(i).value + a.get(j).value < x2) {
                    i++;
                } else if (a.get(i).value + a.get(j).value == x2) {
                    System.out.println(String.format("%d %d %d", a.get(j).idx + 1, a.get(i).idx + 1, a.get(k).idx + 1));
                    return;
                } else {
                    j--;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}
