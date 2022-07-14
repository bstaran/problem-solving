package AC;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public String solution(String command, int arrSize, String arr) {
        String[] str = arr.substring(1, arr.length() - 1).split(",");
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arrSize; i++) {
            dq.offer(Integer.parseInt(str[i]));
        }

        boolean isRight = false;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'R') {
                isRight = !isRight;
            }
            if (c == 'D') {
                if (dq.isEmpty()) return "error";

                if (isRight) dq.pollLast();
                else dq.pollFirst();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isRight) while (!(dq.isEmpty())) sb.append(dq.pollLast()).append(",");
        else while (!(dq.isEmpty())) sb.append(dq.pollFirst()).append(",");
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Main main = new Main();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            bw.write(main.solution(command, arrSize, arr));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
