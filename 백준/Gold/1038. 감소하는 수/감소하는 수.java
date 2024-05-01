import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  static ArrayList<Long> list;
  static int N;

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  private static void pro() {
    if (N <= 10) {
      System.out.println(N);
    } else if (N > 1022) {
      System.out.println(-1);
    } else {
      for (int i = 0; i < 10; i++) {
        recul(i, 1);
      }
      Collections.sort(list);
      System.out.println(list.get(N));
    }
  }

  private static void recul(long num, final int depth) {
    if (depth > 10) {
      return;
    }
    list.add(num);

    for (int i = 0; i < num % 10; i++) {
      recul((num * 10) + i, depth + 1);
    }
    return;
  }

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    list = new ArrayList<>();
  }
}