import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * You are given an array of n integers, and your task is to find four values (at distinct positions) whose sum is x.
 *
 * Input
 *
 * The first input line has two integers n and x: the array size and the target sum.
 * The second line has n integers a1,a2,…,an: the array values.
 *
 * Output
 *
 * Print four integers: the positions of the values.
 * If there are several solutions, you may print any of them. If there are no solutions, print IMPOSSIBLE.
 *
 * */
public class SumFourValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final int x = Integer.parseInt(st.nextToken());
        final double fX = x / 4.;

        boolean allLessF = true;
        boolean allMoreF = true;
        List<Integer> eqF = new ArrayList<>();

        List<Pair> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            a.add(new Pair(val, i));
            if (val >= fX) allLessF = false;
            if (val <= fX) allMoreF = false;
            if (val == fX) eqF.add(i);
        }

        if (allLessF || allMoreF) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        if (eqF.size() >= 4) {
            System.out.println(String.format("%d %d %d %d", eqF.get(0) + 1, eqF.get(1) + 1,
                    eqF.get(2) + 1, eqF.get(3) + 1));
            return;
        }

        a.sort(Pair::compareTo);

        // for all elements using solution for sum of two values
        for (int m = 0; m < a.size(); m++) {
            int x3 = x - a.get(m).value;
            if (x3 <= 0) continue;
            for (int k = 0; k < a.size(); k++) {
                int x2 = x3 - a.get(k).value;
                if (k == m) continue;
                if (x2 <= 0) continue;
                int i = 0;
                int j = a.size() - 1;
                while (i < j) {
                    if (i == k || i == m) {
                        i++;
                        continue;
                    }
                    if (j == k || j == m) {
                        j--;
                        continue;
                    }
                    if (a.get(i).value + a.get(j).value < x2) {
                        i++;
                    } else if (a.get(i).value + a.get(j).value == x2) {
                        System.out.println(String.format("%d %d %d %d", a.get(j).idx + 1, a.get(i).idx + 1,
                                a.get(k).idx + 1, a.get(m).idx + 1));
                        return;
                    } else {
                        j--;
                    }
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
