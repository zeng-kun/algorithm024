class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1 找到递归中止条件，即根节点属于特殊情况：为空，或者为待找的节点节点本身
        if(root == null || root == p || root == q) return root;

        //2 递归调用下一层，即到子树中去寻找，这两个节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //按照子树返回的结果特性返回最后结果
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}