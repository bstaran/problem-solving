package 같은숫자는싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] arr) {

        Queue<Integer> q = new LinkedList<>();

        for (int i : arr) {
            q.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            if (q.size()==1) list.add(q.poll());
            else {
                int n = q.poll();
                if (!q.isEmpty()&&q.peek()!=n){
                    list.add(n);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i]=list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }
}
