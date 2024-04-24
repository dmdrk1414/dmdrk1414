import java.io.*;
import java.util.*;

public class Main {

  static Integer N, M;
  static StringBuilder sb = new StringBuilder();
  static int[] selected;

  public static void rec_funk(final int k) {
    // 종료 조건
    if (k == M + 1) {
      for (int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    }
    // 계속 조건
    else {
      for (int i = 1; i <= N; i++) {
        selected[k] = i;
        rec_funk(k + 1);
        selected[k] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    N = Integer.valueOf(input.split(" ")[0]);
    M = Integer.valueOf(input.split(" ")[1]);
    selected = new int[M + 1];

    rec_funk(1);
    System.out.println(sb);
  }
}