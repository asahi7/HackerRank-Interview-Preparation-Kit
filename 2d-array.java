import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean isInRange(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int di[] = {-1, -1, -1, 0, 1, 1, 1};
        int dj[] = {-1, 0, 1, 0, -1, 0, 1};
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                int n = arr.length;
                int m = arr[i].length;
                int sum = 0;
                boolean outOfRange = false;
                for(int k = 0; k < 7; k++) {
                    if(!isInRange(i + di[k], j + dj[k], n, m)) {
                        outOfRange = true;
                        break;
                    }
                    sum += arr[i + di[k]][j + dj[k]];
                }
                if(!outOfRange) {
                    answer = Math.max(answer, sum);
                }
            }
        }
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

