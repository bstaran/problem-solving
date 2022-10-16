package 크레인인형뽑기게임;

import java.util.*;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        //queue 배열 선언
        Queue<Integer>[] boardQueue = new LinkedList[board.length];

        //queue 배열에 board 요소들 초기화
        for (int i = 0; i < board.length; i++) {
            boardQueue[i] = new LinkedList<>(); // 배열 안에 stack 선언
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 0) boardQueue[i].offer(board[j][i]);
            }
        }

        // queue 배열 배치 확인
//        for (int i = 0; i < boardStack.length; i++) {
//            System.out.println(boardStack[i]);
//        }

        List<Integer> basket = new ArrayList<>(); // 크레인이 뽑은 인형을 보관하는 바구니
        for (int i = 0; i < moves.length; i++) {
            if (!(boardQueue[moves[i] - 1].isEmpty())) {
                basket.add(boardQueue[moves[i] - 1].poll()); // 비어있는지 체크 후 꺼내 바구니에 넣기
                if (basket.size() > 1 && basket.get(basket.size() - 1) == basket.get(basket.size() - 2)) { // 같은 인형이 겹친다면 ++후 삭제
                    answer += 2;
                    basket.remove(basket.size() - 2);
                    basket.remove(basket.size() - 1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution solution = new Solution();

//        for (int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
//        System.out.println("------------------------");

        System.out.println(solution.solution(board, moves));

    }
}
