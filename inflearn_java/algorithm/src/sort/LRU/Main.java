package sort.LRU;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] LRU(int s, int[] arr) {
        /**
         * 5(cache size) 9(task amount)
         * [1 2 3 2 6 2 3 5 7]
         *
         * 1. 배열에 빈 index를 조회. -> 있다면 채워야 한다.
         * 2. 배열에 빈 index가 없다면 -> 배열 안에 같은 작업이 있다면 -> 배열 0번째로
         * 3. 배열 안에 같은 작업이 없다면 -> 배열 0번째 나머지는 한칸씩 뒤로
         */

        int[] resultArr = new int[s];

        for (int i = 0; i < arr.length; i++) {

            int emptyIdx = -1;
            for (int j = 0; j < s; j++) {
                if (resultArr[j] == 0) { // 빈 배열 index를 찾는다.
                    emptyIdx = j;
                    break;
                }
            }
            if (emptyIdx != -1) {
                for (int j = emptyIdx; j > 0; j--) resultArr[j] = resultArr[j - 1];

                resultArr[0] = arr[i];
            } else {
                int presentInList=0;
                for (int j = 0; j < s; j++) {
                    if (resultArr[j] == arr[i]) {
                        presentInList = j;
                        break;
                    }
                }

                if (presentInList != 0) {
                    for (int j = presentInList; j > 0; j--) resultArr[j] = resultArr[j - 1];

                    resultArr[0] = arr[i];
                } else {
                    for (int j = resultArr.length - 1; j > 0; j--) resultArr[j] = resultArr[j - 1];

                    resultArr[0] = arr[i];
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] answer = LRU(S, arr);

        for(int n : answer) bw.write(n + " ");

        bw.flush();
        bw.close();
    }
}
