import java.io.IOException;
import java.util.Scanner;

/*=====================================================================

======================================================================*/

public class bj_2447 {
    public static char[][] result;
    public static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '*';
            }
        }
        star(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int n){
        if (n < 3) {
            return;
        }
        for (int i = x+n/3; i < x+n/3*2; i++) {
            for (int j = y+n/3; j < y+n/3*2; j++) {
                result[i][j] = ' ';
            }
        }
        for (int i=x; i<x+n; i=i+n/3) {
            for (int j=y; j<y+n; j=j+n/3) {
                if (!(i==n/3 && j==n/3)) {
                    star(i, j, n / 3);
                }
            }
        }
    }
}