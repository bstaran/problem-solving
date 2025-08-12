package 블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int value = arr[i] + arr[j] + arr[k];
                    if (value > max) continue;
                    int currentValue = max - value;
                    int beforeValue = max - answer;
                    if (Math.min(Math.abs(currentValue), Math.abs(beforeValue))==currentValue) answer=value;
                }
            }
        }
        System.out.println(answer);
    }
}
