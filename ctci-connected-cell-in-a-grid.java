
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
  
    static boolean checkBoundaries(int i, int j, int n, int m) {
      return i >= 0 && i < n && j >= 0 && j < m;
    }
  
    static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
      int answer = 1;
      visited[i][j] = true;
      for(int k = 0; k < 8; k++) {
        int newI = i + di[k];
        int newJ = j + dj[k];
        if(checkBoundaries(newI, newJ, grid.length, grid[0].length) && grid[newI][newJ] == 1 && visited[newI][newJ] == false) {
          answer += dfs(grid, newI, newJ, visited);
        }
      }
      return answer;
    }
  
    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      int maxRegion = 0;
      for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[0].length; j++) {
          if(grid[i][j] == 1 && visited[i][j] == false) {
            int region = dfs(grid, i, j, visited);
            maxRegion = Math.max(region, maxRegion);
          } 
        }
      }
      return maxRegion;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
