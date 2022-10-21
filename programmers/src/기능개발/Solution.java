package 기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {


        Queue<Function> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++)
            q.add(new Function(progresses[i], speeds[i]));

        int days = 0;
        while (!q.isEmpty()) {
            days++;

            Function f = q.peek();
            int progress = f.progress;
            int speed = f.speed;

            int cnt=0;
            if (speed*days+progress >= 100) {
                cnt++;
                q.poll();

                while (!q.isEmpty()) {
                    Function function = q.peek();
                    if (function.speed*days+ function.progress >= 100) {
                        cnt++;
                        q.poll();
                    }
                    else break;
                }
                list.add(cnt);
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

        System.out.println(Arrays.toString(s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}

class Function {
    int progress;
    int speed;

    public Function(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}