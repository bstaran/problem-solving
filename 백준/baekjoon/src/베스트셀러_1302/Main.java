package 베스트셀러_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int maxValue = Collections.max(values);

        for (String key : keys) {
            if (map.get(key) == maxValue) {
                System.out.println(key);
                break;
            }
        }

        br.close();
    }
}
