package 바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int pc;
    static int N;
    static boolean[] check;
    static int[][] arr;
    static int count=0;
    public static int dfs(int n) {

        count++;
        check[n]=true;

        for (int i = 1; i <= pc; i++) {
            if (arr[n][i]==1 && !check[i]) dfs(i);
        }

        return count-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pc = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        check = new boolean[pc+1];
        arr = new int[pc+1][pc+1];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pc1 = Integer.parseInt(st.nextToken());
            int pc2 = Integer.parseInt(st.nextToken());

            arr[pc1][pc2] = 1;
            arr[pc2][pc1] = 1;
        }

        System.out.println(dfs(1));
    }
}
