class Solution {
    // static Map map = new HashMap<>();
    static Map<Integer,Integer> resultMap = new HashMap<>();

    public int climbStairs(int n) {
   //递归中止条件
        if(n<3){
            return n;
        }
        //用于存放已经计算过的台阶数
        // Map<Integer,Integer> resultMap = new HashMap<>();
        if(resultMap.containsKey(n-1)&&resultMap.containsKey(n-2)){
            resultMap.put(n,resultMap.get(n-1)+resultMap.get(n-2));
        }else {
            resultMap.put(n-1,climbStairs(n-1));
            resultMap.put(n-2,climbStairs(n-2));
            resultMap.put(n,resultMap.get(n-1)+resultMap.get(n-2));
        }
        return resultMap.get(n);

    }
}