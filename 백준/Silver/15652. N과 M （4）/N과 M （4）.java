import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

  private static int N, M;
  private static int[] selected;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();

  private static void input() throws IOException {
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    selected = new int[M + 1];
  }

  private static void recur(final int m_index) {
    if (m_index > M) {
      for (int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int i = 1; i <= N; i++) {
        if (m_index > 1 && selected[m_index - 1] <= i) {
          selected[m_index] = i;
          recur(m_index + 1);
          selected[m_index] = 0;
        } else if (m_index == 1) {
          selected[m_index] = i;
          recur(m_index + 1);
          selected[m_index] = 0;
        }
      }
    }
  }

  private static void pro() throws IOException {
    input();
    recur(1);
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    pro();
  }
}