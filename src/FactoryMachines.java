import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A factory has n machines which can be used to make products.
 * Your goal is to make a total of t products.
 *
 * For each machine, you know the number of seconds it needs to make a single product.
 * The machines can work simultaneously, and you can freely decide their schedule.
 *
 * What is the shortest time needed to make t products?
 *
 * Input
 *
 * The first input line has two integers n and t: the number of machines and products.
 * The next line has n integers k1,k2,…,kn: the time needed to make a product using each machine.
 *
 * Output
 *
 * Print one integer: the minimum time needed to make t products.
 *
 * */
public class FactoryMachines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());
        final int products = Integer.parseInt(st.nextToken());

        int[] k = new int[n];
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n;i++) {
            k[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, k[i]);
        }

        // use binary search to find minimum of time
        long p = -1;
        for (long b = (long) products * min; b >= 1; b /= 2) {
            if (!valid(b+p,products, k)) p += b;
        }
        // sometimes binary search get wrong solution, so we need to check
        if (valid(p+1, products, k))  System.out.println(p+1);
        else System.out.println(p+2);
    }

    private static boolean valid(long time, int products, int[] k) {
        long tasks = 0;
        for (int ki : k) {
            // tasks that ki machine can make in time
            tasks += time / ki;
            if (tasks >= products) return true;
        }
        return false;
    }
}
