package DP.최대부분증가수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dy[0]=1;

        int answer=0;

        for (int i = 1; i < N; i++) {
            int max=0;
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[i] > arr[j] && max < dy[j]) max=dy[j];
            }
            dy[i]=max+1;
            answer=Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }
}
