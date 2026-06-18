import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {

        int[] A = {3, 30, 34, 5, 9};
        String result = solution(A);

        System.out.println(result);
    }

    /*


     */

    public static String solution(int[] numbers) {
        String[] tmp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            tmp[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s);
        }
        String answer = sb.toString();

        if(answer.startsWith("0")) return "0";
        return answer;
    }



}