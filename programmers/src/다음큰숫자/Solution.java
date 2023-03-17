package 다음큰숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int oneCount = getOneCount(n);

        int tmp = n;
        while (true) {
            tmp++;
            if (oneCount == getOneCount(tmp)) {
                answer = tmp;
                break;
            }
        }

        return answer;
    }

    private int getOneCount(int n) {

        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                cnt++;
            }
            n/=2;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(78));
    }
}
