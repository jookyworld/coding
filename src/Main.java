import java.io.IOException;
import java.util.Scanner;

/*=====================================================================

======================================================================*/

public class Main {
    public static char[][] result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result = new char[n][n];
        star(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int n, boolean check){
        if (check) {
            for (int i = x; i < x+n; i++) {
                for (int j = y; j < y+n; j++) {
                    result[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            result[x][y] = '*';
            return;
        }
        int count = 0;
        for (int i=x; i<x+n; i=i+n/3) {
            for (int j=y; j<y+n; j=j+n/3) {
                count++;
                if (count == 5) {
                    star(i, j, n / 3, true);
                } else {
                    star(i, j, n / 3, false);
                }
            }
        }


//        star(x,y, n/3);
//        star(x,y+n/3, n/3);
//        star(x,y+n/3 + n/3, n/3);
//
//        star(x+n/3,y, n/3);
////      star(n/3,n/3, n/3);
//        star(x+n/3,y+n/3+n/3, n/3);
//
//        star(x+n/3+n/3,y, n/3);
//        star(x+n/3+n/3,y+n/3, n/3);
//        star(x+n/3+n/3,y+n/3 + n/3, n/3);

    }
}