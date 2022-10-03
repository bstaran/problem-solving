package greedy.최대수입스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Schedule> list = new ArrayList<>();

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int pay = Integer.parseInt(s[0]);
            int deadline = Integer.parseInt(s[1]);
            maxDay = Math.max(maxDay, deadline);
            list.add(new Schedule(pay, deadline));
        }

        list.sort((o1, o2) -> {
            if (o2.deadline == o1.deadline) return o2.pay - o1.pay;
            return o2.deadline - o1.deadline;
        });

        int answer = 0;
        int j=0;
        for (int i=maxDay; i>0; i--) {
            while (j<n) {
                if (list.get(j).deadline<i) break;
                pQ.offer(list.get(j).pay);
                j++;
            }
            if (!pQ.isEmpty()) answer+=pQ.poll();
        }

        System.out.println(answer);
    }
}

class Schedule {
    int pay;
    int deadline;

    public Schedule(int pay, int deadline) {
        this.pay = pay;
        this.deadline = deadline;
    }
}
