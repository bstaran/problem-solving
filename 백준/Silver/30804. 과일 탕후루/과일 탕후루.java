import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] fruits = new int[N];
    for (int i = 0; i < N; i++) {
      fruits[i] = Integer.parseInt(st.nextToken());
    }

    int fruitsCount = getFruitsCount(fruits, N);

    System.out.println(fruitsCount);
  }

  private static int getFruitsCount(int[] fruits, int N) {
    Map<Integer, Integer> fruitType = new HashMap<>();
    fruitType.put(fruits[0], 1);

    int l = 0;
    int r = 0;
    int fruitsCount = 1;
    while (r < N - 1) {
      r++;
      fruitType.put(fruits[r], fruitType.getOrDefault(fruits[r], 0) + 1);

      while (fruitType.size() > 2) {
        fruitType.put(fruits[l], fruitType.get(fruits[l]) - 1);
        if (fruitType.get(fruits[l]) == 0) {
          fruitType.remove(fruits[l]);
        }
        l++;
      }
      fruitsCount = Math.max(fruitsCount, r - l + 1);
    }
    return fruitsCount;
  }
}
