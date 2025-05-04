import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*===========================================================================
1. 사랍수 n, 관계수 m 입력
2. 한줄씩 입력하면서 arraylist 배열 생성
3. arraylist 완성
4. 순환하면서 깊이가 5라면 1, 아니라면 0 출력
=============================================================================*/

public class bj_13023 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (check) {
                break;
            }
        }
        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void DFS(int num, int count) {
        visited[num] = true;
        if (count == 5) {
            check = true;
            return;
        }
        for (int i : A[num]) {
            if (!visited[i]) {
                DFS(i, count+1);
            }
        }
        visited[num] = false;
    }
}
