import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();


        quickSort(a, 0, n-1, k-1);
        System.out.println(a[k-1]);
    }

    public static void quickSort(int[] a, int s, int e, int k) {
        System.out.println("called quickSort method");
        if(s < e) {
            int pivot = partition(a, s, e);
            if(pivot == k) {
                return;
            }else if(k < pivot) {
                quickSort(a, s, pivot-1, k);
                System.out.println("called quickSort method");
            }else {
                quickSort(a, pivot+1, e, k);
                System.out.println("called quickSort method");
            }
        }
    }

    public static int partition(int[] a, int s, int e) {
        if(s+1 == e) {
            if(a[s] > a[e]) {
                swap(a, s, e);
            }
            return e;
        }
        int m = (s+e)/2;
        swap(a, s, m);
        int pivot = a[s];
        int i = s+1, j=e;
        System.out.println("초기값  / i= " + i + ", j= " + j);
        System.out.println();
        while(i<=j) {
            while(j>=s+1 && pivot < a[j]) {
                j--;
                for(int x=0; x<=e; x++) {
                    System.out.print(a[x]+" ");
                }
                System.out.println();
                System.out.println("j-- 실행됨   / i= " + i + ", j= " + j);
            }
            while(i<=e && a[i] < pivot) {
                i++;
                for(int x=0; x<=e; x++) {
                    System.out.print(a[x]+" ");
                }
                System.out.println();
                System.out.println("i++ 실행됨   / i= " + i + ", j= " + j);
            }
            if(i<=j) {
                swap(a, i++, j--);
                for(int x=0; x<=e; x++) {
                    System.out.print(a[x]+" ");
                }
                System.out.println();
                System.out.println("swap 실행됨   / i= " + i + ", j= " + j);
            }
        }
        for(int x=0; x<=e; x++) {
            System.out.print(a[x]+" ");
        }
        System.out.println();
        System.out.println("한판 다 끝났음  / i= " + i + ", j= " + j);
        a[s] = a[j];
        a[j] = pivot;
        System.out.println("pivot is " + j);
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
