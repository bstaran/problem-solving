package 통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 산술평균
        double avg = 0;
        for (int i = 0; i < N; i++) {
            avg+=arr[i];
        }
        avg=Math.round(avg / N);
        System.out.println((int) avg);

        // 중앙값
        System.out.println(arr[N/2]);

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> highestValues = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int highest = 0;
        for (int i = 0; i < N; i++) {
            int num = map.get(arr[i]);
            if (num > highest) {
                highest = num;
            }
        }
        for (int i = 0; i < N; i++) {
            int num = map.get(arr[i]);
            if (num == highest) {
                highestValues.add(arr[i]);
            }
        }
        if (highestValues.size() >= 2) {
            highestValues.pollFirst();
        }
        System.out.println(highestValues.pollFirst());

        // 범위
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(Math.abs(min - max));

        br.close();
    }
}
