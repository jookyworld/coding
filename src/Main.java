import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] A;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new String[num];
        for (int i = 0; i < num; i++) {
            A[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        String[] result = solution(A, n);

        for (int i = 0; i < A.length; i++) {
            System.out.println(result[i]);
        }
    }

    static public String[] solution(String[] strings, int n) {
        String[] answer = {};
        char[] tmp = new char[strings.length];
        for (int i = 0; i < strings.length; i++) {
            tmp[i] = strings[i].charAt(n);
        }
        Arrays.sort(tmp);
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (tmp[i] == strings[j].charAt(n)) {
                    answer[i] = strings[j];
                }
            }
        }
        return answer;
    }

}