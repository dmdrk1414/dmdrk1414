import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, cnt;
  static int[] board;

  /*
8

92
   */
  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt();
    board = new int[N];
  }

  static void rec_func(int idx) {
    if (idx == N) {
      cnt++;
      return;
    } else {
      for (int i = 0; i < N; i++) {
        board[idx] = i;
        if (possible(idx)) {
          rec_func(idx + 1);
        }
      }
    }
  }

  private static boolean possible(final int idx) {
    for (int i = 0; i < idx; i++) {
      if (board[i] == board[idx]
          || ((idx - i) == Math.abs(board[idx] - board[i]))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    input();
    rec_func(0);
    System.out.println(cnt);
  }


  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}