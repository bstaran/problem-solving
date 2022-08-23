package sort.뮤직비디오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int m, int[] arr) {

        int answer = 0;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        while (start<=end) {
            int mid = (start+end)/2;

            int count=1, sum=0;
            for (int num : arr) {
                if (sum + num > mid) {
                    count++;
                    sum=num;
                } else sum+=num;
            }

            if (count<=m) {
                answer=mid;
                end=mid-1;
            } else start = mid+1;
        }

        return answer;
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

        System.out.println(solution(M,arr));
    }
}
