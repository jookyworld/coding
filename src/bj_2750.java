import java.util.Scanner;

public class bj_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
         a[i] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++) {
            for(int j=1; j<n-i; j++){
                if(a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
        for(int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
    }
}
