package sort.장난꾸러기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int c=0,mate=0;


//        for (int i = 0; i < N; i++) {
//            if (i > 0 && arr[i] < arr[i-1]) mate = i+1;
//            if(i < N-1 && c == 0 && arr[i] > arr[i+1]) {
//
//                if (arr[i] == arr[i-1]){
//                    int idx = i-1;
//                    while (arr[i] == arr[idx]) {
//                        idx--;
//                        if (arr[i]!=arr[idx]) c = idx+2;
//                    }
//                } else c=i+1;
//            }
//        }
//        System.out.println(c + " " + mate);

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < N; i++) {
            if (tmp[i] != arr[i]) System.out.print(i+1 + " ");
        }
    }
}
