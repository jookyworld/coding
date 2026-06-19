import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {

        int[] A = {3, 0, 6, 1, 5};
        int[] B = {5, 1, 6, 7, 2, 2, 2};
        int[] C = {0,0,0,0,0};
        int result = solution(C);

        System.out.println(result);
    }

    /*
    정렬 시켜놓고 반복문 돌면서 찾으면 끝 아닌가..?
    6 5 3 1 0
    7 6 5 2 2 2 1
    2 2 2 2 1 1
    1 1 1 0 0
    0 0 0
     */

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int count = 1;

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] == count) {
                return count;
            } else if (citations[i] < count) {
                return count -1;
            }
            count++;
        }
        return count - 1;
    }



}