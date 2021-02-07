class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        return getChildNode(root,resultList);

    }

    private List<Integer> getChildNode(TreeNode childNode, List<Integer> resultList) {
        if(childNode == null){
            return resultList;
        }else {
            resultList = getChildNode(childNode.left,resultList);
            resultList.add(childNode.val);
            resultList = getChildNode(childNode.right,resultList);
        }
        return resultList;
    }
}