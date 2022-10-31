package 다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer=0;
        int sum=0;

        Queue<Integer> q = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            while (true) {

                if (q.isEmpty()) {
                    q.add(truck_weight);
                    answer++;
                    sum+=truck_weight;
                    break;
                } else if (q.size() >= bridge_length){
                    sum-= q.poll();
                } else {
                    if (sum + truck_weight <= weight) {
                        sum+=truck_weight;
                        answer++;
                        q.offer(truck_weight);
                        break;
                    } else {
                        answer++;
                        q.offer(0);
                    }
                }
            }
        }


        return answer + bridge_length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(2, 10, new int[]{7,4,5,6}));
    }
}
