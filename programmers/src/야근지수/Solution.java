package 야근지수;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works)
            pq.offer((long) work);

        while (n > 0 && !pq.isEmpty()) {
            Long num = pq.poll();
            if (num != 0) {
                num-=1;
                n-=1;
                pq.offer(num);
            }
        }

        while (!pq.isEmpty()) {
            Long num = pq.poll();
            answer += num * num;
        }

        return answer;
    }
}