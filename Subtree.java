public class Subtree{
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static void main(String args[]){
		//Creating our main root
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		//Creating our subTree
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        System.out.println(issubtree(root, subroot));


    }
    public static boolean issubtree(Node root, Node subroot) {
        if (root == null || subroot == null) {
            return false;  // Added null check to handle null nodes
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        return issubtree(root.left, subroot) || issubtree(root.right, subroot);
    }
    
    public static boolean isIdentical(Node node,Node subroot){
        //Lets create cases for non-Identical
        if(node==null&&subroot==null){
            return true;
        }else if(node==null||subroot==null||node.data!=subroot.data){
            return false;
        }
        if(!isIdentical(node.left, subroot)){
            return false;
        }
        if(!isIdentical(node.right, subroot)){
            return false;
        }
        return true;
    }
}