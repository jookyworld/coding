import java.io.*;
import java.util.Arrays;

public class bj_10989 {
    public static int[] a;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        br.close();
//        RadixSort(a, 5);
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static void RadixSort(int[] a, int n) {

    }
}
