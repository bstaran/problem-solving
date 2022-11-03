package 디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int sum = 0, end = 0, idx = 0, count=0;

        while (count < jobs.length) {

            while (idx < jobs.length && jobs[idx][0] <= end) {
                pQ.offer(jobs[idx++]);
            }

            if (pQ.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] poll = pQ.poll();
                end+=poll[1];
                sum+=end-poll[0];
                count++;
            }
        }
        return sum/ jobs.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[][]{{0, 3}, {3, 9}, {10, 2}, {7, 6}}));
    }
}