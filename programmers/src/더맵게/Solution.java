package 더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i : scoville) {
            pQ.offer(i);
        }

        while (pQ.peek()<=K) {
            if (pQ.size()<2) return answer=-1;

            pQ.offer(pQ.poll() + (pQ.poll()*2));
            answer++;
        }


        return answer;
    }
}
