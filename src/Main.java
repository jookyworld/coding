import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {

        int[] A = {1, 5, 2, 6, 3, 7, 4};
        int[] result = solution(A, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /*


     */

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }

        return answer;
    }



}