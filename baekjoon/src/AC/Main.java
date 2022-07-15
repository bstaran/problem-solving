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
        if (!dq.isEmpty()) sb.append(isRight ? dq.pollLast() : dq.pollFirst());
        if (isRight) while (!(dq.isEmpty())) sb.append(",").append(dq.pollLast());
        else while (!(dq.isEmpty())) sb.append(",").append(dq.pollFirst());
        sb.append("]");
        return sb.toString();
    }

    // 무조건 숫자, 이런식으로 넣은 다음에 마지막 반점을 빼주신거고
    // 숫자 하나 넣고 그 뒤에 들어가는것들을 ,숫자 이런식으로 넣는거죠

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
