package twoPoint_slidingWindow.q4_연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int p1 = 0, p2 = 1, sum = arr[0];
        int answer = 0;
        while (p2<n) {

            if (sum < m) {
                sum += arr[p2++];
            } else if (sum > m) {
                sum -= arr[p1++];
            }

            if (sum == m) {
                answer++;
                sum-=arr[p1++];
            }
        }
        System.out.println(answer);
    }
}
