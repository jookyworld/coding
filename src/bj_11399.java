import java.util.Arrays;
import java.util.Scanner;

public class bj_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] s = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=1; i<n; i++) {
            int insert_point = i;
            int insert_value = a[i];
            for(int j=i-1; j>=0; j--) {     //i 왼쪽 인덱스 전체 루프
                if(a[j]<a[i]) {             //j 값이 i 값보다 작다면
                    insert_point = j+1;     //삽입 포인트는 j 하나 오른쪽으로 저장
                    break;                  //그 전 인덱스들은 이미 정렬 된 상태 (확인불필요)
                }
                if(j==0) {                  //제일 왼쪽까지 확인했다면(i 왼쪽이 전부 i 보다 크다면)
                    insert_point = 0;       //삽입 포인트는 제일 왼쪽으로 저장
                }
            }
            for(int j=i; j>insert_point; j--) { //i부터 삽입포인트 오른쪽까지 전부
                a[j] = a[j-1];                  //오른쪽으로 한칸씩 밀기
            }
            a[insert_point] = insert_value;
        }
        s[0] = a[0];
        for(int i=1; i<n; i++) {
            s[i] = s[i-1] + a[i];
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum = sum + s[i];
        }
        System.out.println(sum);
    }
}
