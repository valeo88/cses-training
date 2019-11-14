import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * There is a street of length x whose positions are numbered 0,1,…,x.
 * Initially there are no traffic lights, but n sets of traffic lights are added to the street one after another.
 *
 * Your task is to calculate the length of the longest passage without traffic lights after each addition.
 *
 * Input
 *
 * The first input line contains two integers x and n: the length of the street and the number of sets of traffic lights.
 * Then, the next line contains n integers p1,p2,…,pn: the position of each set of traffic lights. Each position is distinct.
 *
 * Output
 *
 * Print the length of the longest passage without traffic lights after each addition.
 *
 * */
public class TrafficLights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int x = Integer.parseInt(st.nextToken());
        final int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< n; i++) {
            int p = Integer.parseInt(st.nextToken());

            System.out.print(0);
            System.out.print(" ");
        }

    }
}
