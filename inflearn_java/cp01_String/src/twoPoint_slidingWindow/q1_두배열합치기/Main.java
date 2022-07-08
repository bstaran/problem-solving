package twoPoint_slidingWindow.q1_두배열합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // 보통의 방법으로 풀기
//    public String solution(int[] arr1, int[] arr2) {
//
//        int num = arr1.length + arr2.length;
//        int[] result = new int[num];
//        for (int i = 0; i < arr1.length + arr2.length; i++) {
//            if (arr1.length > i) result[i] = arr1[i];
//            else result[i] = arr2[i - arr1.length];
//        }
//
//        Arrays.sort(result);
//        StringBuilder sb = new StringBuilder();
//        for (int n : result) {
//            sb.append(n + " ");
//        }
//
//        return sb.toString();
//    }
    // 투 포인트
    public String solution(int[] arr1, int[] arr2) {

        StringBuilder sb = new StringBuilder();

        int p1=0, p2=0; // 포인터 두개를 생성
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1]<arr2[p2]) sb.append(arr1[p1++] + " ");
            else sb.append(arr2[p2++] + " ");
        }
        while (p1<arr1.length) sb.append(arr1[p1++] + " ");
        while (p2<arr2.length) sb.append(arr2[p2++] + " ");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr1string = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] arr2string = br.readLine().split(" ");

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(arr1string[i]);
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(arr2string[i]);
        }

        Main main = new Main();
        System.out.println(main.solution(arr1, arr2));
    }
}
