package dataStructure.공주구하기;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= size; i++) q.offer(i);

        int i = 0;
        while (true) {
            i++;
            if (i % n == 0) {
                if (q.size()==1) {
                    System.out.println(q.pollFirst());
                    break;
                }
                q.pollFirst();
            } else q.offerLast(q.pollFirst());
        }
    }
}
