import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int ch[] = new int[26];
        for(int i = 0; i < a.length(); i++) {
            ch[a.charAt(i) - 'a']++;
        }
        for(int j = 0; j < b.length(); j++) {
            ch[b.charAt(j) - 'a']--;
        }
        int sum = 0;
        for(int i = 0; i < 26; i++) {
            sum += Math.abs(ch[i]);
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
