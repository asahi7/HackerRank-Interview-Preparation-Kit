
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Pair {
      public int a;
      public int b;
      public Pair(int a, int b) {
        this.a = a;
        this.b = b;
      }
    }
  
    // Complete the isValid function below.
    static String isValid(String s) {
      // aabbcd => 2 2 1 1 => 2 twos 2 ones
      // aabbccddeefghi => 2 2 2 2 2 1 1 1 1 => 5 twos 4 ones
      // abcdefghhgfedecba => 2 2 2 2 3 2 2 2 => 7 twos, 1 three  
      // aabbc => 2 2 1 => 2 twos 1 one
      int[] a = new int[26];
      for(int i = 0; i < s.length(); i++) {
        a[s.charAt(i) - 'a']++;
      }
      Pair[] pairs = new Pair[26];
      for(int i = 0; i < 26; i++) {
        pairs[i] = new Pair(a[i], i);
      }
      Arrays.sort(pairs, new Comparator<Pair>() {
        public int compare(Pair o1, Pair o2) {
          if(o1.a == 0) {
            return 1;
          } else if(o2.a == 0) {
            return -1;
          }
          return (o1.a < o2.a || (o1.a == o2.a && o1.b < o2.b)) ? -1 : 1;
        }
      });
      // 122 => 1 one, 2 twos
      int prev = -1, groups = 0;
      int first = -1, second = -1, firstCount = 0, secondCount = 0;
      for(int i = 0; i < 26; i++) {
        if(pairs[i].a == 0) {
          break;
        }
        if(first == pairs[i].a) {
          firstCount++;
        } 
        if(second == pairs[i].a) {
          secondCount++;
        }
        if(pairs[i].a != prev) {
          if(first == -1) {
            first = pairs[i].a;
            firstCount = 1;
          } else if(second == -1) {
            second = pairs[i].a;
            secondCount = 1;
          } else {
            return "NO";
          }
          prev = pairs[i].a;
          groups++;
        }
      }
      // 122 => 1 one, 2 twos
      // 113 => 1 three, 2 ones
      // aabbc => 122
      if(groups > 2) {
        return "NO"; // a bb ccc
      } else if(groups < 2) {
        return "YES";
      } else {
        if(firstCount == 1) {
          if(first == 1) {
            return "YES";
          }
          return first - 1 == second ? "YES" : "NO";
        } else if(secondCount == 1) {
          if(second == 1) {
            return "YES";
          }
          return second - 1 == first ? "YES" : "NO";
        } else {
          return "NO";
        }
      }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
