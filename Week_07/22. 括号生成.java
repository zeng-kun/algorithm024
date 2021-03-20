//方案一
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //处理特殊情况
        if(n==0){
            return res;
        }
        //深度优先搜索
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        if(left==0&&right==0){
            res.add(curStr);
            return;
        }

        if(left>right){
            return;
        }

        if(left>0){
            dfs(curStr+"(",left-1,right,res);
        }
        if(right>0){
            dfs(curStr+")",left,right-1,res);
        }
    }
    }

    //方案二
    //import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    class Node {

        private String res;
      
        private int left;
    
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }
}
