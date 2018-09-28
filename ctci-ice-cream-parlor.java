
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < cost.length; i++) {
        int toPut;
        if(!map.containsKey(cost[i])) {
          toPut = 1;
        } else {
          toPut = map.get(cost[i]) + 1;
        }
        map.put(cost[i], toPut);
      }
      int first = -1, second = -1;
      for(int i = 0; i < cost.length; i++) {
        if(cost[i] < money) {
          map.put(cost[i], map.get(cost[i]) - 1);
          int toFind = money - cost[i];
          if(map.containsKey(toFind) && map.get(toFind) >= 1) {
            first = cost[i];
            second = toFind;
            break;
          }
          map.put(cost[i], map.get(cost[i]) + 1);
        }
      }
      int firstIndex = -1, secondIndex = -1;
      for(int i = 0; i < cost.length; i++) {
        if(first == cost[i] && firstIndex == -1) {
          firstIndex = i;
        } else if(second == cost[i] && secondIndex == -1) {
          secondIndex = i;
        }
      }
      System.out.println((firstIndex + 1) + " " + (secondIndex + 1));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
