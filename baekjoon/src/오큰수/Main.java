package 오큰수;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) stack.push(i);
            else {
                while (!(stack.isEmpty())) {
                    if (arr[stack.peek()] < arr[i]) arr[stack.pop()] = arr[i];
                    else break;
                }
                stack.push(i);
            }
            if (i == N - 1) while (!(stack.isEmpty())) arr[stack.pop()] = -1;
        }
        arr[arr.length - 1] = -1;
        for (int n : arr) bw.write(n + " ");
        br.close();
        bw.flush();
        bw.close();

    }
}

// 5 4 3 2 1 3 10

// 5 4 3 2 1
// 3 10
