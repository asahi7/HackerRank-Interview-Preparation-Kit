import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int res = 0, lastCount = 0;
        char ch = '\0';
        // AAABBB
        // 123123
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ch) {
                if(lastCount > 1) {
                    res += lastCount - 1;
                }
                ch = s.charAt(i);
                lastCount = 1;
            } else {
                lastCount++;
            }
        }
        if(lastCount > 1) {
            res += lastCount - 1;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
