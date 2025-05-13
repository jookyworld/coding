import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1697 {
    static int k;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        visited = new int[100001];
        int result = BFS(n);
        System.out.println(result);
    }

    static int BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                return visited[now];
            }
            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                queue.add(now + 1);
                visited[now + 1] = visited[now] + 1;
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                queue.add(now - 1);
                visited[now - 1] = visited[now] + 1;
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                queue.add(now * 2);
                visited[now * 2] = visited[now] + 1;
            }
        }
        return -1;
    }
}