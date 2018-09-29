
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long sumDigits(long val) {
      long sum = 0;
      while(val != 0) {
        sum += val % 10;
        val /= 10;
      }
      return sum;
    }
    
    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
      long sum = 0;
      for(int i = 0; i < n.length(); i++) {
        sum += (n.charAt(i) - '0') * 1L;
      }
      sum = sum * k;
      while(true) {
        if(sum / 10 == 0) {
          return (int) sum;
        }
        sum = sumDigits(sum);
      }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
