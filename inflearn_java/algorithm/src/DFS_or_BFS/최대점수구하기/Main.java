package DFS_or_BFS.최대점수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Question[] arr;
    static int n;
    static int m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Question[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            arr[i] = new Question(score, limit);
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int i, int limitSum, int sum) {

        if (limitSum > m) return;

        if (i==n) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(i+1, limitSum+arr[i].limit, sum+arr[i].score);
        dfs(i+1, limitSum, sum);
    }
}

class Question {
    int score;
    int limit;

    public Question(int score, int limit) {
        this.score = score;
        this.limit = limit;
    }
}