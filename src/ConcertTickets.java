import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

        List<Integer> prices = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            prices.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> customerMaxPrices = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            customerMaxPrices.add(Integer.parseInt(st.nextToken()));
        }

        prices.sort(Integer::compareTo);

        for (int maxPrice: customerMaxPrices) {
            // calc ticket price for customer
            int size = prices.size();
            if (size > 0) {
                int idx = lowerBound(prices, maxPrice);
                if (idx == 0 && prices.get(idx) != maxPrice) {
                    System.out.println(-1);
                    continue;
                }
                if (idx==size || prices.get(idx) > maxPrice) idx--;
                System.out.println(prices.get(idx));
                prices.remove(idx);
            } else {
                System.out.println(-1);
            }
        }
    }

    /** Works like C++ lower_bound
     * Get index of element equal or more than value */
    public static <T> int lowerBound(List<? extends Comparable<? super T>> list, T value) {
        final int size = list.size();
        int start = 0;
        int end = size-1;
        int mid = (start + end) >>> 1;
        while (true) {
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0 || cmp > 0) {
                end = mid - 1;
                if (end < start)
                    return mid;
            } else {
                start = mid + 1;
                if (end < start)
                    return mid < size - 1 ? mid + 1 : size;
            }
            mid = (start + end) >>> 1;
        }
    }
}
