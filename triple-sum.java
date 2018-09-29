import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    static int findLargestSmallerEqualIndex(int[] a, int[] b, int i) {
      int l = 0, r = a.length - 1, index = -1;
      while(l <= r) {
        int mid = (l + r) / 2;
        if(a[mid] > b[i]) {
          r = mid - 1;
        } else {
          index = mid;
          l = mid + 1;
        }
      }
      return index + 1;
    }
  
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
      a = IntStream.of(a).distinct().toArray();
      b = IntStream.of(b).distinct().toArray();
      c = IntStream.of(c).distinct().toArray();
      Arrays.sort(a);
      Arrays.sort(b);
      Arrays.sort(c);
      long res = 0;
      for(int i = 0; i < b.length; i++) {
        // b[i] >= a[pIndex], same as q >= p
        // b[i] >= c[rIndex], same as q >= r
        int pIndex = findLargestSmallerEqualIndex(a, b, i);
        int rIndex = findLargestSmallerEqualIndex(c, b, i);
        if(pIndex <= 0 || rIndex <= 0) {
          continue;
        }
        res += Long.valueOf(pIndex) * Long.valueOf(rIndex);
      }
      return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
