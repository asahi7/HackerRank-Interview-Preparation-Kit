import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
      // This solution does not work for test case 3:
      // 7
      // 1 3 5 2 4 6 8
      // But the testcase is wrong, because contains 8 not included in [1..n]
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < arr.length; i++) {
        map.put(arr[i], i);
      }
      int swaps = 0;
      for(int i = 0; i < arr.length; i++) {
        if(arr[i] != i + 1) {
          swaps++;
          int temp = arr[i];
          arr[i] = i + 1;
          int newPos = map.get(i + 1);
          arr[newPos] = temp;
          map.put(temp, newPos);
        }
      }
      return swaps;
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

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
