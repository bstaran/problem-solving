package 네번째수_2997;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int dif = Math.min(arr[1] - arr[0], arr[2] - arr[1]);

        if (arr[0] + dif != arr[1]) {
            System.out.println(arr[0] + dif);
        } else if (arr[1] + dif != arr[2]) {
            System.out.println(arr[1] + dif);
        } else {
            System.out.println(arr[2] + dif);
        }

        br.close();
    }
}