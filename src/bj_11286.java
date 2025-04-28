import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
1. 연산개수 n 입력
2. x!=0 > 배열에 x 추가
    x==0 > 배열에서 절댓값 가장 작은 값 출력, 배열에서 제거 / 배열 비어있으면 0 출력
*/

public class bj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) {   //절대값이 같으면
                return o1 > o2 ? 1 : -1;    //음수 우선 정렬
            }else {     //절댓값이 다르다면
                return first_abs-second_abs;
            }
        });
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }else {
                    System.out.println(0);
                }
            }else {
                queue.add(x);
            }
        }
    }
}
