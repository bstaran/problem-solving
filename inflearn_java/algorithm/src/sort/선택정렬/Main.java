package sort.선택정렬;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /**
     * 6
     * 13 5 11 7 23 15
     */

    public static int[] selectionSort(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;

                if (j == N-1) {
                    int tmp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selectionSort(arr, N);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
