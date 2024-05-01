import java.io.*;
import java.util.*;

public class Main {

  static int N, ans;
  static int[][] egg;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    egg = new int[N][2]; // 내구도, 무게

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      egg[i][0] = Integer.parseInt(st.nextToken());
      egg[i][1] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    solution(0, 0);
    System.out.println(ans);
  }

  private static void solution(int now, int breakEgg) {

    ans = Math.max(ans, breakEgg);
    if (now == N) {
      return; // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란
    }
    if (egg[now][0] <= 0) {
      solution(now + 1, breakEgg); // 손에 든 계란이 깨진 경우
    } else {
      for (int next = 0; next < N; next++) {
        if (next == now || egg[next][0] <= 0) {
          continue; // 깨지지 않은 다른 계란을 치기 위해
        }

        // 계란으로 계란을 치게 되면
        // 각 계란의 내구도는 상대 계란의 무게만큼 깎임
        egg[now][0] -= egg[next][1];
        egg[next][0] -= egg[now][1];

        int newBreakEgg = breakEgg;
        if (egg[now][0] <= 0) {
          newBreakEgg++;
        }
        if (egg[next][0] <= 0) {
          newBreakEgg++;
        }

        solution(now + 1, newBreakEgg);

        // 복구
        egg[now][0] += egg[next][1];
        egg[next][0] += egg[now][1];
      }
    }
  }
}