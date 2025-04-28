import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String program = st.nextToken();
            switch (program) {
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                    last = x;
                    break;
                case "pop" :
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    }else {
                        System.out.println(queue.poll());
                    }
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peek());
                    break;
                case "back" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(last);
                    break;
            }
        }
    }
}
