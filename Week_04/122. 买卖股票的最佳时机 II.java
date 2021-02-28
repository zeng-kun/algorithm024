class Solution {
    public int maxProfit(int[] prices) {
        //把买的股票放在栈里，交易一次就出栈
        //这是一道应用题，问题就在于该怎么建模？
        //看到关键词“最大利润”，可以考虑使用贪心法来解决。贪心法，类似于只活在当下，不看过去，不在乎未来
        //本题的
        int len = prices.length;
        //1. 考虑特殊情况，
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                //在这道题目中，只要大于0的结果
                res += diff;
            }
        }
        return res;
    }
}

//最后作者给的反证法，也是挺有意思的
//prices[i] - prices[i - 1] 下面用差分来形容，如果存在一个更好的结果的话，其在每一次计算时都能获得一个差分
//当差分为0时，总收益不变；
//当差分为负时，会使总收益减少；
//当差分为正，即为所求