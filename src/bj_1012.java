import java.util.Scanner;

/*
1. n, m, k 입력
2. k만큼 반복 돌면서
    배추가 있는 위치 1로 지정
3. DFS 돌면서
    구역 수 ++
 */

public class bj_1012 {
    static int[][] A;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        A = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            A[x][y] = 1;
        }
    }
}
