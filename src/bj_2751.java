import java.io.*;

public class bj_2751 {
    public static int[] a, tmp;
    public static long result;
    public static int num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n + 1];
        tmp = new int[n + 1];
        for(int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        merget_sort(1, n);
        for(int i=1; i<=n; i++) {
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void merget_sort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2;
        merget_sort(s, m);          // s ~ m
        merget_sort(m + 1, e);  // m+1 ~ e          여기서 이미 1개 단위로 다 쪼개짐
        for(int i=s; i<=e; i++) {
            tmp[i] = a[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                a[k] = tmp[index2];
                k++;
                index2++;
            }else {
                a[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            a[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            a[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
