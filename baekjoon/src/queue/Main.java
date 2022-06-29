package queue;

import java.io.*;

public class Main {
    private static int[] queue;
    private static int size = 0;
    private static int front = 0;
    private static int back = 0;

    public static void push(int n) {
        queue[back] = n;
        size++;
        back++;
    }

    public static int pop() {
        if (size == 0) return -1;
        size--;
        front++;
        return queue[front - 1];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) return 1;
        return 0;
    }

    public static int front() {
        if (size == 0) return -1;
        return queue[front];
    }

    public static int back() {
        if (size == 0) return -1;
        return queue[back - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        queue = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < queue.length; i++) {
            String s = br.readLine();
            if (s.contains("push")) {
                String[] cm = s.split(" ");
                push(Integer.parseInt(cm[1]));
            } else if (s.equals("pop")) {
                bw.write(pop() + "\n");
            } else if (s.equals("size")) {
                bw.write(size() + "\n");
            } else if (s.equals("empty")) {
                bw.write(empty() + "\n");
            } else if (s.equals("front")) {
                bw.write(front() + "\n");
            } else if (s.equals("back")) {
                bw.write(back() + "\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
