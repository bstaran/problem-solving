package hashMapAndHashSet.매출액의종류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public String solution(int[] arr, int K) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < K; i++) hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        sb.append(hashMap.size()).append(" ");
        for (int i = 1; K < arr.length; i++, ++K) {
            if (hashMap.get(arr[i - 1]) == 1) hashMap.remove(arr[i - 1]);
            else hashMap.put(arr[i - 1], hashMap.get(arr[i - 1]) - 1);
            hashMap.put(arr[K], hashMap.getOrDefault(arr[K], 0) + 1);

            sb.append(hashMap.size()).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(arr, K));
    }
}
