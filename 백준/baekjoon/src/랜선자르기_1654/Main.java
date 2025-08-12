package 랜선자르기_1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        long min=0, max=Integer.MIN_VALUE, mid=0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max+=1;
        br.close();

        while (min < max) {

            int count = 0;
            mid = (min+max)/2;

            for (int i = 0; i < K; i++) {
                count += (arr[i]/mid);
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max-1);
    }
}
