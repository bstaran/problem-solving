package 패션왕신해빈_9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }
            Collection<Integer> values = map.values();

            int result = 1;
            Iterator<Integer> iterator = values.iterator();
            while (iterator.hasNext()) {
                // +1을 하는 이유는 해당 옷을 입지 않는 경우도 포함하기 위함
                result *= iterator.next() + 1;
            }
            System.out.println(result - 1);

            map.clear();
        }
        br.close();
    }
}
