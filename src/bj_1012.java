import java.util.Scanner;

/*
1. n, m, k 입력
2. k만큼 반복 돌면서
    배추가 있는 위치 1로 지정
3. DFS 돌면서
    구역 수 ++
 */

public class bj_1012 {
    static int n;
    static int m;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int z = 0; z < t; z++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int k = sc.nextInt();
            A = new int[n][m];
            int result = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                A[x][y] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && A[i][j] == 1) {
                        DFS(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void DFS(int a, int b) {
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && y >= 0 && x < n && y < m) {
                if (!visited[x][y] && A[x][y] == 1) {
                    DFS(x, y);
                }
            }
        }
    }
}
