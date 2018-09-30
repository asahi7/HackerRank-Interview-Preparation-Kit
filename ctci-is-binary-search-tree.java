
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean recurse(Node root, int l, int r) {
      if(root == null) {
        return true;
      }
      if(l != -1 && root.data <= l) {
        return false;
      }
      if(r != -1 && root.data >= r) {
        return false;
      }
      return recurse(root.left, l, root.data) && recurse(root.right, root.data, r);
    }

    boolean checkBST(Node root) {
      return recurse(root, -1, -1);
    }
