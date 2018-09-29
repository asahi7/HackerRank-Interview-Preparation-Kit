
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  
    /*
    11
    2 3
    4 -1
    5 -1
    6 -1
    7 8
    -1 9
    -1 -1
    10 11
    -1 -1
    -1 -1
    -1 -1
    2
    2
    4
    */
    static void makeTraversal(int[][] indexes, int root, List<Integer> answer) {
      if(indexes[root][0] != -1) {
        makeTraversal(indexes, indexes[root][0] - 1, answer);
      } 
      answer.add(root + 1);
      if(indexes[root][1] != -1) {
        makeTraversal(indexes, indexes[root][1] - 1, answer);
      }
    }
  
    static void swapSubtrees(int[][] indexes, int root, int k, int depth) {
      if(depth == k) {
        int temp = indexes[root][0];
        indexes[root][0] = indexes[root][1];
        indexes[root][1] = temp;
      }
      if(indexes[root][0] != -1) {
        swapSubtrees(indexes, indexes[root][0] - 1, k, depth + 1);
      } 
      if(indexes[root][1] != -1) {
        swapSubtrees(indexes, indexes[root][1] - 1, k, depth + 1);
      }
    }
  
    static int[][] swapNodes(int[][] indexes, int[] queries) {
      int[][] result = new int[queries.length][indexes.length];
      for(int i = 0; i < queries.length; i++) {
        int k = queries[i];
        for(int j = 1; j * k <= indexes.length; j++) {
          swapSubtrees(indexes, 0, j * k, 1);
        }
        List<Integer> list = new ArrayList<>();
        makeTraversal(indexes, 0, list);
        for(int j = 0; j < list.size(); j++) {
          result[i][j] = list.get(j);
        }
      }
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
