import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. n, m 입력
2. 표 입력받아서 [][] 생성
3. BFS 시작
    4. 주변 4개를 탐색해야함 for(4)문
    5. 1이고 방문하지 않은 구간이라면, m,n의 범주 안이라면
        6. BFS 시행
 */

public class bj_2178 {
    static int[][] A;
    static boolean[][] visited;
    static int count = 1;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[n-1][m-1]);
    }
    //1,0   0,1     -1,0    0,-1
    static void BFS(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = tmp[0] + dx[k];
                int y = tmp[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        A[x][y] = A[tmp[0]][tmp[1]] + 1;
                        count++;
                    }
                }
            }
        }
    }
}
