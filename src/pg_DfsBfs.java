import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pg_DfsBfs {
    static int[][] A;
    static boolean[][] visited;
    static int[][] distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n=5;       //문제에 맞게 수정
    static int m=5;       //문제에 맞게 수정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] input_var = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                input_var[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }


        System.out.println(solution(input_var));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }

    static public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        A = maps;
        visited = new boolean[n][m];
        distance = new int[n][m];
        distance[0][0] = 1;
        int result =  BFS(0, 0);
        if (result == 0) {
            return -1;
        } else {
            return result;
        }
    }

    static int BFS(int a, int b) {
        visited[a][b] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (!visited[x][y] && A[x][y] == 1) {
                        visited[x][y] = true;
                        distance[x][y] = distance[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}