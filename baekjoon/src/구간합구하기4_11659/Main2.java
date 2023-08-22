package 구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] nums = new int[N+1];
        int[] prefixSum = new int[N+1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(input[i-1]);
        }

        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i-1] + nums[i];
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            System.out.println(prefixSum[n2] - prefixSum[n1 - 1]);
        }
    }
}
