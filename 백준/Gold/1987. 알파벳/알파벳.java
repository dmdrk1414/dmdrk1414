import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int MAX = Integer.MIN_VALUE;
  static String[] graph;
  static boolean[] visited;
  static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static boolean[] seleted = new boolean[26];
  static int cnt;

  /*
3 6
HFDFFB
AJHGDH
DGAGEH

   */
  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt();
    M = scan.nextInt();
    graph = new String[N];
    for (int i = 0; i < N; i++) {
      graph[i] = scan.nextLine();
    }
    visited = new boolean[26];
  }

  static void pro() {
    recul(0, 0, 1);
    System.out.println(MAX);
  }

  private static void recul(final int x, final int y, final int len) {
    visited[graph[x].charAt(y) - 'A'] = true;
    MAX = Math.max(MAX, len);

    for (int i = 0; i < 4; i++) {
      int nx = x + dir[i][0];
      int ny = y + dir[i][1];

      if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
        continue;
      }
      if (!visited[graph[nx].charAt(ny) - 'A']) {
        visited[graph[nx].charAt(ny) - 'A'] = true;
        recul(nx, ny, len + 1);
        visited[graph[nx].charAt(ny) - 'A'] = false;
      }
    }
  }

  static void print(List<int[]> arr) {
    for (final int[] ints : arr) {
      System.out.println(ints[0] + " " + ints[1]);
    }
  }

  public static void main(String[] args) {
    input();
    pro();
  }

  private static void print(final boolean[][] arr) {
    for (final boolean[] booleans : arr) {
      System.out.println(Arrays.toString(booleans));
    }
  }

  static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
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