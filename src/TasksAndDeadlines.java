import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 You have to process n tasks. Each task has a duration and a deadline,
 and you will process the tasks in some order one after another.
 Your reward for a task is d−f where d is its deadline and f is your finishing time.
 (The starting time is 0, and you have to process all tasks even if a task would yield negative reward.)

 What is your maximum reward if you act optimally?

 Input

 The first input line has an integer n: the number of tasks.
 After this, there are n lines that describe the tasks. Each line has two integers a and d: the duration and deadline of the task.

 Output

 Print one integer: the maximum reward.
 *
 * */
public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tasks.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // sort by duration (short tasks should be first for correct greedy algorithm)
        tasks.sort(Comparator.comparingInt(t -> t.duration));

        long reward = 0;
        long time = 0;
        for (Task task : tasks) {
            time += task.duration;
            reward += task.deadline - time;
        }

        System.out.println(reward);

    }

    private static class Task {
        int duration;
        int deadline;

        public Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }
}
