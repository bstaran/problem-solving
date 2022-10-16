package 소수만들기;

public class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int n = nums[i] + nums[j] + nums[k];
                    if (isPrime(n)) count++;
                }
            }
        }
        System.out.println(count);

        return count;
    }

    /**
     *
     * 소수는 1과 자기자신으로 밖에 나누어 떨어지지 않는 수.
     * 소수를 구하기 위해선 해당 숫자까지 나머지가 0이 없는지 검사해야 한다.
     * 루트를 이용해 구하면 시간복잡도를 반으로 줄일 수 있다.
     * 20 => [20 * 1, 10 * 2, 5 * 4], [5 * 4, 2 * 10, 1 * 20] 으로 절반은 같은 식을 검사한다.
     *
     */
    public boolean isPrime(int num) {
        int p = (int) Math.sqrt(num);
        for (int i = 2; i <= p; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 7, 6, 4});
    }
}
