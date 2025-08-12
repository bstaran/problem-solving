package min_heap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 시간초과..
     * 리스트로 구현보다 연결리스트, 배열* 구현.
     * 리스트는 요소를 삽입할 때 모든 요소가 한 칸씩 뒤로 밀려나기 때문에 시간 비용이 더 높음
     *
      */
    private static List<Integer> heapList = new ArrayList<>();

    public static void push(int n) {
        for (int i = 0; i < heapList.size(); i++) {
            if (heapList.get(i) > n) {
                heapList.add(i, n);
                break;
            }
            if (heapList.size() == i + 1) {
                heapList.add(n);
                break;
            }
        }

        if (heapList.size() == 0) heapList.add(n);
    }

    public static int pop() {
        if (heapList.size() == 0) return 0;
        int n = heapList.get(0);
        heapList.remove(0);
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.equals("0")) {
                bw.write(pop() + "\n");
                bw.flush();
            } else {
                push(Integer.parseInt(command));
            }
        }

        bw.close();
        br.close();

//        bw.write(pop()+"\n");
//        bw.flush();
//        push(12345678);
//        push(1);
//        push(2);
//        bw.write(pop()+"\n");
//        bw.flush();
//        bw.write(pop()+"\n");
//        bw.flush();
//        bw.write(pop()+"\n");
//        bw.flush();
//        bw.write(pop()+"\n");
//        bw.flush();
//        bw.close();
    }
}
