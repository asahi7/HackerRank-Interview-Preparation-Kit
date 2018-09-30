
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long computeProduction(long days, long[] machines) {
      long production = 0;
      for(int i = 0; i < machines.length; i++) {
        production += days / machines[i];
      }
      return production;
    }
  
    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
      long l = 1, r = 1000000000000000000L; 
      long result = -1;
      while(l <= r) {
        long mid = (l + r) / 2;
        long production = computeProduction(mid, machines);
        if(production < goal) {
          l = mid + 1;
        } else if(production >= goal) {
          result = mid;
          r = mid - 1;
        } 
      }
      l = 1;
      r = Integer.MAX_VALUE; 
      long result2 = -1;
      while(l <= r) {
        long mid = (l + r) / 2;
        long production = computeProduction(mid, machines);
        if(production < goal) {
          l = mid + 1;
        } else if(production >= goal) {
          result2 = mid;
          r = mid - 1;
        } 
      }
      if(result == -1) {
        return result2;
      } else if(result2 == -1) {
        return result;
      }
      return Math.min(result, result2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
