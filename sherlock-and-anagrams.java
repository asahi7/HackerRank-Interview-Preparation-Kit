import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Range {
      public int a, b;
      public Range(int a, int b) {
        this.a = a;
        this.b = b;
      }
      public boolean equals(Object other) {
        Range o = (Range) other;
        return o == this ? true : (o.a == this.a && o.b == this.b);
      }  
      public int hashCode() {
        return this.a * 31 + this.b * 31;
      }
    }
  
    static String sortString(String str) {
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      return new String(arr);
    }
  
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
      Map<String, Set<Range>> anagramPairs = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
        for(int j = i; j < s.length(); j++) {
          String sub = s.substring(i, j + 1);
          String sorted = sortString(sub);
          if(! anagramPairs.containsKey(sorted)) {
            anagramPairs.put(sorted, new HashSet<Range>());
          }
          anagramPairs.get(sorted).add(new Range(i, j));
        }
      }
      int result = 0;
      for(Map.Entry<String, Set<Range>> entry : anagramPairs.entrySet()) {
        int quantity = entry.getValue().size();
        if(quantity > 1) {
          result += quantity * (quantity - 1) / 2;
        }
      }
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
