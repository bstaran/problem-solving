package 나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색
        int min = 0, mid = 0, answer = 2_000_000_000;
        int max = Arrays.stream(arr).max().getAsInt();
        while (min <= max) {

            mid = (min+max)/2;

            long result = 0;
            for (int i = 0; i < N; i++) {
                long tmp = arr[i] - mid;
                if (tmp > 0) {
                    result+=tmp;
                }
            }

            if (result < M) {
                max = mid-1;
            } else {
                answer =  mid;
                min = mid+1;
            }

        }

        System.out.println(answer);

        br.close();
    }
}
