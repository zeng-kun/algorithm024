class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //1. 首先考虑递归中止条件
        if(preorder.length ==0 || inorder.length ==0){
            return null;
        }

        //2. 这一轮循环要做的事情
        //根据前序遍历的特征：根左右，拿到该树的根节点
        TreeNode treeNode = new TreeNode(preorder[0]);

        //再结合中序遍历（左右根），该树分成左右两颗子树
        for(int i = 0;i<inorder.length;i++){
            //在中序遍历中找到根元素的位置
            if(inorder[i] == treeNode.val){
                //将树进行分割，分别得到左、右子树的前序、中序遍历结果，以便进行下一轮的递归
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);

                //3. 进入下一层
                treeNode.left = buildTree(pre_left,in_left);
                treeNode.right = buildTree(pre_right,in_right);
                break;
            }
        }
    return treeNode;
    }
}