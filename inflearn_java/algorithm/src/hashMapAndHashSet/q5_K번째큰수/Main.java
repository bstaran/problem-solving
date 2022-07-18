package hashMapAndHashSet.q5_K번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        int answer = -1;
        for (int i = 0; i < K; i++) {
            if (i == K - 1 && !(treeSet.isEmpty())) answer = treeSet.pollFirst();
            treeSet.pollFirst();
        }
        System.out.println(answer);
    }
}
