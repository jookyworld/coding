import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class tmp
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String t = st.nextToken();
        String p = st.nextToken();

        System.out.println(solution(t, p));
    }

    static public int solution(String t, String p) {
        int answer = 0;
        long b = Long.parseLong(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            long a = Long.parseLong(t.substring(i, i + p.length()));
            if (a <= b) {
                answer++;
            }
        }
        return answer;
    }


}
