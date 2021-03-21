//方案1
class Solution {
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }
    private void dfs (HashSet<String> step, int stepCount, 
        String current, String end, String[] bank) {
        if (current.equals(end)) 
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str: bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) 
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}

//方案2：
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[][] banks = new char[bank.length][8];
        for (int i = 0; i < bank.length; i++) {
            banks[i] = bank[i].toCharArray();
        }
        solution1(start.toCharArray(), end.toCharArray(), banks, 0);
        return minChange == Integer.MAX_VALUE ? -1 : minChange;
    }
    int minChange = Integer.MAX_VALUE;
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:37.1 MB,击败了98.97% 的Java用户
    private void solution1(char[] start, char[] end, char[][] bank, int change) {
        if (Arrays.equals(start, end)) {
            minChange = Math.min(minChange, change);
            return;
        }
        for (int j = 0; j < bank.length; j++) {
            char[] piece = bank[j];
            if (piece == null) continue; // 已用过的片段
            int diff = 0; // 获取基因库中不同为1的片段,作为改变一次后的新start
            for (int i = 0; i < start.length; i++) {
                if (start[i] != piece[i]) diff++;
            }
            if (diff == 1) {
                bank[j] = null; // 置空,防止循环使用
                solution1(piece, end, bank, change + 1);
                bank[j] = piece; // 还原回溯
            }
        }
    }
}