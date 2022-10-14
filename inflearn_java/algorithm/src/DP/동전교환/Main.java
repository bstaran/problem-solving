package DP.동전교환;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        for (int i = 0; i < n; i++)
            coins[i]= Integer.parseInt(st.nextToken());

        int money = sc.nextInt();

        int[] dy = new int[money+1];

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0; // 없으면 overflow
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= money; j++) {
                dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
            }
        }

        System.out.println(dy[money]);
    }
    
}
