
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //   2 1 5 8 4
    //   2 2 7 10 11
  
    // -1 -2 -3 -4 -5
    // -1 -1 -1 -1 -1
  
    // -1 -2 -3 -4 5
    // 5
    static int maxSubsetSum(int[] arr) {
      int[] d = new int[arr.length];
      if(arr.length >= 1) {
        d[0] = arr[0];
      }
      if(arr.length >= 2) {
        d[1] = Math.max(arr[1], d[0]);
      }
      for(int i = 2; i < arr.length; i++) {
        int c1 = d[i - 2] + arr[i];
        int c2 = d[i - 2];
        int c3 = d[i - 1];
        int c4 = arr[i];
        d[i] = Math.max(Math.max(c1, Math.max(c2, c3)), c4);
      }
      int result = Integer.MIN_VALUE;
      for(int i = 0; i < d.length; i++) {
        result = Math.max(result, d[i]);
      }
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
