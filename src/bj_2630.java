import java.io.IOException;
import java.util.Scanner;

/*=====================================================================
1. 정수 n과
2. n x n 이차원 배열 입력하고 저장
3. 전체 색이 같지 않다면
    4. n/2 x n/2 으로 구간 분리
5. 색이 같다면
    6. 해당(흰 or 파랑)+1
     s m / m+1 e
    s
    m
    m+1
    e

    sm / m+1 e s m / s m m+1 e / m+1 e
    x시작좌표, y시작좌표, n
 ======================================================================*/

public class bj_2630 {
    public static int[][] arr;
    public static int b = 0;
    public static int w = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        n_sort(0, 0, n);
        System.out.println(w);
        System.out.println(b);
    }

    public static void n_sort(int x, int y, int n) {
        boolean check = true;
        if (n < 1) {
            return;
        }
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) {
                    check = false;
                    break;
                }
            }
        }
        if (!check) {
            n_sort(x, y, n / 2);
            n_sort(x, y + n / 2, n / 2);
            n_sort(x + n / 2, y, n / 2);
            n_sort(x + n / 2, y + n / 2, n / 2);
        } else {
            if (arr[x][y] == 1) {
                b++;
            } else {
                w++;
            }
        }
    }
}
