class Solution {
     static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        flag=true;
        levels(root);
        return flag;
    }
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftlevel= levels(root.left);
        int rightlevel= levels(root.right);
        if(Math.abs(leftlevel-rightlevel)>1) flag=false;
        return 1+Math.max(leftlevel,rightlevel);
    }
}