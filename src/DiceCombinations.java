import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Your task is to count the number of ways to construct sum n by throwing a dice one or more times.
 * Each throw produces an outcome between 1 and 6.
 *
 * For example, if n=3, there are 4 ways:
 *
 * 1+1+1
 * 1+2
 * 2+1
 * 3
 *
 * Input
 * The only input line has an integer n.
 * Output
 * Print the number of ways modulo 10^9+7.
 * */
public class DiceCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final long modulo = 1000000007L;

        long[] cnt = new long[n+1];
        cnt[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 6); j < i; j++) {
                cnt[i] = (cnt[i] + cnt[j]) % modulo;
            }
        }
        System.out.println(cnt[n]);

    }
}
