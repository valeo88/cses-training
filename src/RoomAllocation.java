import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * There is a large hotel, and n customers will arrive soon. Each customer wants to have a single room.
 * You know each customer's arrival and departure day.
 * Two customers can stay in the same room if the departure day of the first customer is earlier than the arrival day of the second customer.
 *
 * What is the minimum number of rooms that are needed to accommodate all customers? And how can the rooms be allocated?
 *
 * Input
 *
 * The first input line contains an integer n: the number of customers.
 * Then there are n lines, each of which describes one customer. Each line has two integers a and b: the arrival and departure day.
 *
 * Output
 *
 * Print first an integer k: the minimum number of rooms required.
 * After that, print a line that contains the room number of each customer in the same order as in the input.
 * The rooms are numbered 1,2,…,k.
 * */
public class RoomAllocation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        List<Customer> customers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            customers.add(new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }

        // sort by depature
        customers.sort(Comparator.comparingInt(c -> c.dep));

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dep));

        int k = 0;
        for (Customer c : customers) {
            int roomNum = 0;
            if (pq.isEmpty() || pq.peek().dep >= c.arr) {
                roomNum = ++k;
            } else {
                Pair pc = pq.poll();
                roomNum = pc.room;
            }
            c.setRoom(roomNum);
            pq.add(new Pair(c.dep, roomNum));
        }

        System.out.println(k);
        customers.sort(Comparator.comparingInt(c -> c.idx));
        System.out.println(customers.stream()
                .map(customer -> String.valueOf(customer.room))
                .collect(Collectors.joining(" ")));

    }

    private static class Pair {
        int dep;
        int room;

        public Pair(int dep, int room) {
            this.dep = dep;
            this.room = room;
        }
    }

    private static class Customer {
        int arr;
        int dep;
        int idx;
        int room;

        public Customer(int arr, int dep, int idx) {
            this.arr = arr;
            this.dep = dep;
            this.idx = idx;
        }

        public int getRoom() {
            return room;
        }

        public void setRoom(int room) {
            this.room = room;
        }
    }
}
