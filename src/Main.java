import java.io.*;
import java.util.*;

/*
1.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {   //절대값이 같으면
                return o1 > o2 ? 1 : -1;    //음수 우선 정렬
            } else {     //절댓값이 다르다면
                return first_abs - second_abs;
            }
        });
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                queue.add(x);
            }
        }
    }
}