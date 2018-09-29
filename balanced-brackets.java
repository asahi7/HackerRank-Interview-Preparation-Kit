
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
      Stack<Character> stack = new Stack<>();
      List<Character> open = Arrays.asList('[', '{', '(');
      List<Character> closed = Arrays.asList(']', '}', ')');
      for(int i = 0; i < s.length(); i++) {
        if(open.contains(s.charAt(i))) {
          stack.push(s.charAt(i));
        } else if(closed.contains(s.charAt(i))) {
          int closedBracketIndex = closed.indexOf(s.charAt(i));
          if(stack.size() == 0) {
            return "NO";
          }
          Character openBracket = stack.pop();
          if(open.indexOf(openBracket) != closedBracketIndex) {
            return "NO";
          }
        } else {
          throw new IllegalArgumentException("The chars shoul be one of the brackets");
        }
      }
      return stack.size() == 0 ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
