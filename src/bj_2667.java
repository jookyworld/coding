import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
0. 상하좌우 탐색해야함 /
1. n 입력
2. n*n 배열 입력해서 A[][]에 저장
3. 단지 찾는 함수
4. BFS로 탐색
    4.
*/
public class bj_2667 {
    static int[][] A;
    static boolean[][] visited;
    static int[] danjee = new int[625];
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        n = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j, result);
                    result++;
                }
            }
        }
        System.out.println(result);
        Arrays.sort(danjee);
        for (int i = 0; i < 625; i++) {
            if (danjee[i] != 0) {
                System.out.println(danjee[i]);
            }
        }
    }
    static void BFS(int a, int b, int num) {
        int count = 1;
        visited[a][b] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (!visited[x][y] && A[x][y] == 1) {
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        count++;
                    }
                }
            }
        }
        danjee[num] = count;
    }
}
