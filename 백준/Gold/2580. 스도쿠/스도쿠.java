import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[][] board;
  static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static boolean[] visited_x = new boolean[9];
  static boolean[] visited_y = new boolean[9];
  static Queue<int[]> q = new LinkedList<>();

  /*

0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0

0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

   */
  static void input() {
    FastReader scan = new FastReader();
    N = 9;
    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      String[] input = scan.nextLine().split(" ");
      for (int j = 0; j < input.length; j++) {
        int in = Integer.parseInt(input[j]);
        board[i][j] = in;
        if (in == 0) {
          q.add(new int[]{i, j});
        }
      }
    }
  }

  public static void sudoku(int x, int y) {

    // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
    if (y == 9) {
      sudoku(x + 1, 0);
      return;
    }

    // 행과 열이 모두 채워졌을 경우 출력 후 종료
    if (x == 9) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }

      // 출력 뒤 시스템을 종료한다.
      System.exit(0);
    }

    // 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
    if (board[x][y] == 0) {
      for (int i = 1; i <= 9; i++) {
        // i 값이 중복되지 않는지 검사
        if (valid(x, y, i)) {
          board[x][y] = i;
          sudoku(x, y + 1);
        }
      }
      board[x][y] = 0;
      return;
    }

    sudoku(x, y + 1);

  }

  private static boolean valid(int x, int y, int value) {
    // 열 검사
    for (int i = 0; i < 9; i++) {
      if (board[x][i] == value) {
        return false;
      }
    }

    // 행 검사
    for (int i = 0; i < 9; i++) {
      if (board[i][y] == value) {
        return false;
      }
    }

    // 정방 검사
    int _x = (x / 3) * 3;
    int _y = (y / 3) * 3;
    for (int i = _x; i < _x + 3; i++) {
      for (int j = _y; j < _y + 3; j++) {
        if (board[i][j] == value) {
          return false;
        }
      }
    }

    return true;
  }

  static void pro() {
    sudoku(0, 0);
  }

  static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    input();
    pro();
    print(board);
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