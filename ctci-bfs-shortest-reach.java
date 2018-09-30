
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Pair {
      public int a;
      public int b;
      
      public Pair(int a, int b) {
        this.a = a;
        this.b = b;
      }
      
      public boolean equals(Object o) {
        if(! (o instanceof Pair)) {
          return false;
        }
        Pair p = (Pair) o;
        return this.a == p.a && this.b == p.b;
      }
      
      public int hashCode() {
        int res = 17;
        res = this.a + res * 31;
        res = this.b + res * 31;
        return res;
      }
    }
  
    public static class Graph {
        private List<List<Integer>> g;
        
        public Graph(int size) {
          g = new ArrayList<>(size);
          for(int i = 0; i < size; i++) {
            g.add(new ArrayList<Integer>());
          }
        }

        public void addEdge(int first, int second) {
          g.get(first).add(second);
          g.get(second).add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
          int n = g.size();
          int[] d = new int[n];
          boolean[] visited = new boolean[n];
          for(int i = 0; i < n; i++) {
            d[i] = -1;
          }
          d[startId] = 0;
          TreeSet<Pair> set = new TreeSet<>(new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
              if(o1.a < o2.a) {
                return -1;
              } else if(o1.a > o2.a) {
                return 1;
              } else if(o1.b == o2.b) {
                return 0;
              } else {
                return -1;
              }
            }
          });
          set.add(new Pair(0, startId));
          for(int i = 0; i < n; i++) {
            Pair pair = set.pollFirst();
            if(pair == null) {
              break;
            }
            int s = pair.b;
            visited[s] = true;
            for(int to : g.get(s)) {
              if(d[to] == -1 || (d[to] > d[s] + 1 && visited[to] == false)) {
                set.remove(new Pair(d[to], to));
                d[to] = d[s] + 1;
                set.add(new Pair(d[to], to));
              }
            }
          }
          int[] ans = new int[n];
          for(int i = 0; i < n; i++) {
            ans[i] = (d[i] == -1 ? -1 : d[i] * 6); 
          }
          return ans;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
