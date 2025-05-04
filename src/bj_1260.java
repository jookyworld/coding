import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1260 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[n + 1];
        DFS(v);
        System.out.println();
        visited = new boolean[n + 1];
        BFS(v);
    }
    static void DFS(int num) {
        visited[num] = true;
        System.out.print(num + " ");
        for (int i : A[num]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(num);
        visited[num] = true;
        while (!queue.isEmpty()) {
            int now_num = queue.poll();
            System.out.print(now_num + " ");
            for (int i : A[now_num]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
