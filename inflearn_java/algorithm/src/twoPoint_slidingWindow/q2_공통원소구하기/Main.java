package twoPoint_slidingWindow.q2_공통원소구하기;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//public class Main {
//    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        int p1=0,p2=0;
//        while (p1 < n && p2 < m) {
//            if (a[p1] == b[p2]) {
//                answer.add(a[p1++]);
//                p2++;
//            } else if (a[p1]<b[p2]) p1++;
//            else p2++;
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Main main = new Main();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i]=scanner.nextInt();
//        }
//        int m = scanner.nextInt();
//        int[] b = new int[m];
//        for (int i = 0; i < m; i++) {
//            b[i]=scanner.nextInt();
//        }
//        for (int x : main.solution(n, m, a, b)) System.out.print(x+" ");
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1); // 배열 정렬
        Arrays.sort(arr2);
        int a1=0,a2=0; // 포인터
        while (a1<n&&a2<m) {
            if (arr1[a1] != arr2[a2]) {
                if (arr1[a1] > arr2[a2]) a2++;
                else a1++;
            } else {
                answer.add(arr1[a1]);
                a1++;
                a2++;
            }
        }

        for(int num : answer) bw.write(num + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
