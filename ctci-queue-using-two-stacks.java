
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void transfer() {
          if(stackOldestOnTop.size() == 0 || stackNewestOnTop.size() != 0) {
            return;
          }
          while(stackOldestOnTop.empty() == false) {
            stackNewestOnTop.push(stackOldestOnTop.pop());
          }
        }
      
        public void enqueue(T value) { // Push onto newest stack
          stackOldestOnTop.push(value);
        }

        public T peek() {
          transfer();
          return stackNewestOnTop.peek();
        }

        public T dequeue() {
          transfer();
          return stackNewestOnTop.pop();
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
