import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*=====================================================================

======================================================================*/

public class Main {
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};        // 위 오 아래 왼
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[n - 1][m - 1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j]+ " ");
            }
            System.out.println();
        }

    }

    static void BFS(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();        //큐 생성
        queue.offer(new int[]{i, j});       //(0,0) 큐에 삽입
        while (!queue.isEmpty()) {          //큐가 다 빌때까지
            int now[] = queue.poll();       //큐 안에 한개 poll
            for (int k = 0; k < 4; k++) {   //4번 반복
                int x = now[0] + dx[k];     //
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (A[x][y] != 0 && !visited[x][y]) {       //1이고 방문하지 않은 부분이라면
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}