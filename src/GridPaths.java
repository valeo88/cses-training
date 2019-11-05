import java.io.PrintWriter;
import java.util.Scanner;

/**
 * There are 88418 paths in a 7×7 grid from the upper-left square to the lower-left square.
 * Each path corresponds to a 48-character description consisting of characters D (down), U (up), L (left) and R (right).
 *
 * For example, the path
 *
 * corresponds to the description DRURRRRRDDDLUULDDDLDRRURDDLLLLLURULURRUULDLLDDDD.
 *
 * You are given a description of a path which may also contain characters ? (any direction).
 * Your task is to calculate the number of paths that match the description.
 *
 * Input
 *
 * The only input line has a 48-character string of characters ?, D, U, L and R.
 *
 * Output
 *
 * Print one integer: the total number of paths.
 * */
public class GridPaths {

    public static final int BOARD_SIZE = 7;
    public static final int START_ROW = 0;
    public static final int START_COL = 0;
    public static final int FINISH_ROW = 6;
    public static final int FINISH_COL = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        char[] path = sc.nextLine().toCharArray();
        int[] cnt = new int[1];
        int[] step = new int[1];
        boolean[][] visited = new boolean[BOARD_SIZE][BOARD_SIZE];

        // too slow
        visit(START_ROW, START_COL, cnt, step, path, visited);

        pw.println(cnt[0]);
        pw.flush();

    }

    private static void visit(int r, int l, int[] cnt, int[] step, char[] path, boolean[][] visited) {
        visited[r][l] = true;
        if (r == FINISH_ROW && l == FINISH_COL) {
            if (step[0] == 48) {
                cnt[0]++;
            }
            return;
        }
        if (step[0] > path.length-1) {
            return;
        }
        char[] act;
        if (path[step[0]] != '?') {
            act  = new char[1];
            act[0] = path[step[0]];
        } else {
            act = new char[4];
            act[0] = 'R';
            act[1] = 'D';
            act[2] = 'L';
            act[3] = 'U';
        }
        for (char c : act) {
            int nextRow = r;
            int nextCol = l;
            switch (c) {
                case 'L':
                    nextCol--;
                    break;
                case 'R':
                    nextCol++;
                    break;
                case 'U':
                    nextRow--;
                    break;
                case 'D':
                    nextRow++;
                    break;
            }
            if (nextCol < 0
                    || nextCol > BOARD_SIZE - 1
                    || nextRow < 0
                    || nextRow > BOARD_SIZE - 1
                    || visited[nextRow][nextCol]) {
                continue;
            } else {
                step[0]++;
                visit(nextRow, nextCol, cnt, step, path, visited);
                step[0]--;
                visited[nextRow][nextCol] = false;
            }
        }

    }

}
