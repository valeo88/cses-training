import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * There are n concert tickets available, each with a certain price.
 * Then, m customers arrive, one after another.
 *
 * Each customer announces the maximum price he or she is willing to pay for a ticket, and after this,
 * they will get a ticket with the nearest possible price such that it does not exceed the maximum price.
 *
 * Input
 *
 * The first input line contains integers n and m: the number of tickets and the number of customers.
 * The next line contains n integers h1,h2,…,hn: the price of each ticket.
 * The last line contains m integers t1,t2,…,tm: the maximum price for each customer.
 *
 * Output
 *
 * Print, for each customer, the price that they will pay for their ticket.
 * After this, the ticket cannot be purchased again.
 *
 * If a customer cannot get any ticket, print −1.
 * */
public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        SortedMap<Integer, Integer> prices = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            prices.putIfAbsent(val, 0);
            prices.put(val, prices.get(val)+1);
        }

        List<Integer> customerMaxPrices = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            customerMaxPrices.add(Integer.parseInt(st.nextToken()));
        }

        for (int maxPrice: customerMaxPrices) {
            // calc ticket price for customer
            int size = prices.size();
            if (size > 0) {
                if (prices.firstKey() > maxPrice) {
                    System.out.println(-1);
                    continue;
                }
                SortedMap<Integer, Integer> lessEqualPrices = prices.subMap(1, maxPrice + 1);
                if (lessEqualPrices.size() == 0) {
                    System.out.println(-1);
                } else {
                    Integer lastKey = lessEqualPrices.lastKey();
                    int currValue = lessEqualPrices.get(lastKey);
                    System.out.println(lastKey);
                    currValue--;
                    if (currValue>0) {
                        lessEqualPrices.put(lastKey, currValue);
                    } else {
                        lessEqualPrices.remove(lastKey);
                    }
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
