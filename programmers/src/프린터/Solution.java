package 프린터;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            pQ.offer(priority);
        }

        while (!pQ.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!pQ.isEmpty()&&priorities[i] == pQ.peek()) {
                    pQ.poll();
                    answer++;

                    if (i == location) return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
