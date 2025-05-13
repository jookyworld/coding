import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
변수 A[][], visited, dx, dy
1. m, n 입력
2. for문으로 A[n][m] 채우기
3. for문으로 시작지점 찾기 (1이어야하고 방문하지 않았어야함) / BFS로
4. BFS
    상하좌우 탐색
    숫자 바꿔주기
 */

public class bj_7576 {
    static int[][] A;
    static int n;
    static int m;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        BFS();

        int max = A[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (A[i][j] > max) {
                    max = A[i][j];
                }
            }
        }
        System.out.println(max-1);

        //===============test==================
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
        //====================================
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {       //탐색하려는 주변 4개 구역이 A[][] 범주 안에는 있어야함
                    if (A[x][y]==0) {
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
