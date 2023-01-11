package 검증수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n * n;
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr[i];
        }
        System.out.println(sum % 10);
    }
}
