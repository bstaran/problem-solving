package 이중우선순위큐;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String c = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (c.equals("I")) {
                min.offer(num);
                max.offer(num);
            } else {
                if (min.isEmpty()) continue;
                if (num==-1) {
                    max.remove(min.poll());
                } else {
                    min.remove(max.poll());
                }
            }
        }

        int[] answer = new int[2];

        if (max.size()>=1)
            answer[0] = max.poll();
        if (min.size()>=1)
            answer[1] = min.poll();

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"})));
    }
}
