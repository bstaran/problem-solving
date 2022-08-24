package DFS_or_BFS.합이같은부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int total;
    static String answer="NO";
    static boolean flag;
    public static void dfs(int l, int sum) {

        if (total-sum==sum) answer="YES";
        if (l==arr.length || sum>total/2) return ;

        dfs(l+1, sum+arr[l]);
        dfs(l+1, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        total = Arrays.stream(arr).sum();
        dfs(0, 0);
        System.out.println(answer);
    }
}
