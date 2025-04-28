import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] a= new int[s.length()];
        for(int i=0; i<a.length; i++) {
            a[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for(int i=0; i<a.length-1; i++) {   //0 1 2
            for(int j=i+1; j<a.length; j++) {   //123 23 3
                if(a[i] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
