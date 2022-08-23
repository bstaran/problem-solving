package sort.마구간정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int c, int[] arr) {

        Arrays.sort(arr);
        int start=1, end = arr[arr.length-1];
        int answer = 0;
        while (start <= end) {
            int p = 1;
            int h = 1;
            int mid=(start+end)/2;

            for (int num : arr) {
                if (num - p >= mid) {
                    p=num;
                    h++;
                }
            }

            if (h>=c) {
                start=mid+1;
                answer=mid;
            }
            else end=mid-1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(C,arr));
    }
}
