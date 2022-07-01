package array.q1_큰수출력하기;

import java.io.*;

public class Main {
    public String solution(int n, String s) {

        String[] strings = s.split(" ");
        String answer = strings[0]+" ";
        for (int i = 1; i < n; i++) if (Integer.parseInt(strings[i-1])<Integer.parseInt(strings[i])) answer+=strings[i]+" ";

        return answer;
    }

    // 다른 풀이
//    public ArrayList<Integer> solution(int n, int[] arr) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        answer.add(arr[0]);
//        for (int i = 1; i < n; i++) {
//            if(arr[i]>arr[i-1]) answer.add(arr[i]);
//        }
//        return answer;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(main.solution(n,s));
    }
}
