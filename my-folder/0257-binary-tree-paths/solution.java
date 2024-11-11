/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<String>();
        ArrayList<Integer> p = new ArrayList<Integer>();
        fp(root , p , paths);
        // fp(root.left , p , paths);
        // fp(root.right , p , paths);
        return paths; 
    }
    public static void fp( TreeNode root , ArrayList<Integer> p , ArrayList<String> paths ){
        if( root == null ) return ;
        ArrayList<Integer> pc = new ArrayList<Integer>();
        pc.addAll(p);
        p.add(root.val);
        fp(root.left , p , paths);
        fp(root.right , p , paths);
        if(root.left == null && root.right == null) paths.add(tst(p));
        //p.remove(p.get(p.size()-1));
        p.clear();
        p.addAll(pc);
    }
    public static String tst(ArrayList<Integer> p){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < p.size() ; i++){
            sb.append(p.get(i));
            if(i == p.size()-1)continue;
            sb.append("->");
        }
        return sb.toString();
    }
}
