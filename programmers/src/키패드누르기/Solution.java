package 키패드누르기;

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int leftPosition = 0;
        int rightPosition = 0;

        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftPosition = numbers[i];
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightPosition = numbers[i];
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                    int numberRow = (numbers[i]-1)/3;
                    int numberCol = (numbers[i]-1)%3;
                    break;
            }
        }
        System.out.println(sb);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution.solution(numbers, hand));
    }
}
