package sort.삽입정렬;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            for (int j = i; j > 0; j--) {
                if (arr[idx] < arr[j - 1]) {
                    int tmp = arr[idx];
                    arr[idx] = arr[j - 1];
                    arr[j - 1] = tmp;
                    idx-=1;
                } else {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        insertionSort(arr);

        for (int n : arr) bw.write(n + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
