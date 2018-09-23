	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	if(root.left == null && root.right == null) {
            return 0;
        }
        int res = 0;
        if(root.left != null) {
            res = height(root.left);    
        }
        if(root.right != null) {
            res = Math.max(height(root.right), res);
        }
        return res + 1;
    }
