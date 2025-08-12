package 숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        arr[n] = 1;

        boolean check = true;
        while (check) {
            int idx = queue.poll();

            for (int i = 0; i < 3; i++) { // 3가지 경우의 수 탐색
                int nextIdx;

                if (i == 0) nextIdx = idx + 1;
                else if (i == 1) nextIdx = idx - 1;
                else nextIdx = idx * 2;

                if (nextIdx == k) { // 동생 위치에 도착 시 반환
                    System.out.println(arr[idx]);
                    check = false;
                    break;
                }

                if (nextIdx < arr.length && nextIdx > 0 && arr[nextIdx] == 0 ) { // 방문한 곳 제외
                    queue.offer(nextIdx); // 탐색할 다음 레벨 추가
                    arr[nextIdx] = arr[idx] + 1; // 1초를 더해서 작성
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[200000];

        if (N == K) System.out.println(0);
        else bfs(N, K);
    }
}
