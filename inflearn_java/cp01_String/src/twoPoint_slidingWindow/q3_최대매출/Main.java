package twoPoint_slidingWindow.q3_최대매출;

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

        int answer = 0;
        for (int i = 0; i < m; i++) answer+=arr[i];
        int i=m;
        int c = answer;
        while (i < n) {
            c += arr[i] - arr[i - m];
            if (answer < c) answer = c;
            i++;
        }
        System.out.println(answer);
    }
}
