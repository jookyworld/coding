import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2606 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
            A[b].add(a);
        }
        BFS(1);
        System.out.println(count);
    }
    static void BFS(int s) {
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i : A[tmp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
    }
}