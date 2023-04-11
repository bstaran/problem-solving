package 뱀과사다리게임_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();
    static boolean[] visit = new boolean[101];
    static int answer;
    private static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        board = new int[101];
        answer = Integer.MAX_VALUE;

        bfs();

        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        while (!q.isEmpty()) {

            Integer num = q.poll();

            if (num == 100) {
                System.out.println(board[num]);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int nextStep = num + i;

                if (nextStep > 100) {
                    continue;
                }

                if (ladder.containsKey(nextStep)) {
                    nextStep = ladder.get(nextStep);
                }
                else if (snake.containsKey(nextStep)) {
                    nextStep = snake.get(nextStep);
                }

                if (!visit[nextStep]) {
                    visit[nextStep] = true;
                    board[nextStep] = board[num] + 1;
                    q.add(nextStep);
                }
            }
        }
    }
}
