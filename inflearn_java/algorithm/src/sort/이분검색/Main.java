package sort.이분검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int binarySearch(int[] arr, int N, int M) {

        int startIdx=0, lastIdx=N, middleIdx=Integer.MIN_VALUE;
        while (middleIdx != 0) {
            middleIdx=(startIdx+lastIdx)/2;
            if (arr[middleIdx] == M) return middleIdx+1;

            if (arr[middleIdx] < M) startIdx = middleIdx;
            else lastIdx=middleIdx;
        }
        return -1;
    }

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
        Arrays.sort(arr);

        System.out.println(binarySearch(arr, N, M));


    }
}
