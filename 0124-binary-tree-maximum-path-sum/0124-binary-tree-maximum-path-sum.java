class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        levels(root);
        return max;
    }

    public int levels(TreeNode root) {
        if (root == null) return 0;

        int leftlevel = Math.max(0, levels(root.left));
        int rightlevel = Math.max(0, levels(root.right));

        max = Math.max(max, root.val + leftlevel + rightlevel);

        return root.val + Math.max(leftlevel, rightlevel);
    }
}