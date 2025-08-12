import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int sum = 0;
    int starIndex = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '*') {
        starIndex = i;
        continue;
      }
      if ((i + 1) % 2 == 1) {
        sum += Character.getNumericValue(input.charAt(i));
      } else {
        sum += Character.getNumericValue(input.charAt(i)) * 3;
      }
    }

    for (int i = 0; i < 10; i++) {
      int tempSum = sum;
      if ((starIndex + 1) % 2 == 1) {
        tempSum += i;
      } else {
        tempSum += i * 3;
      }

      if (tempSum % 10 == 0) {
        System.out.println(i);
        return;
      }
    }
  }
}
