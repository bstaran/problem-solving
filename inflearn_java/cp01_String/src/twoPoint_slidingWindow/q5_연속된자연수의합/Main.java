package twoPoint_slidingWindow.q5_연속된자연수의합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i]=i+1;

        int lt=0,rt=1;
        int sum=arr[lt],answer=0;
        while (rt < n) {

            if (sum < n) {
                sum += arr[rt++];
            } else if (sum > n) {
                sum -= arr[lt++];
            }

            if (sum==n) {
                answer++;
                sum -= arr[lt++];
            }
        }
        System.out.println(answer);
    }
}
