class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m) return "";

        Map<Character, Integer> need = new HashMap<Character, Integer>();
        for(int i = 0; i < m; i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[]{0, n};
        int left = 0, needCnt = m;
        for(int right = 0; right < n; right++){
            char cR = s.charAt(right);
            if(need.getOrDefault(cR, 0) > 0){
                needCnt--;
            }
            need.put(cR, need.getOrDefault(cR, 0) - 1);
            if(needCnt == 0){
                while(true){
                    char cL = s.charAt(left);
                    if(need.get(cL) == 0){
                        break;
                    }
                    need.put(cL, need.get(cL) + 1);
                    left++;
                }
                if(right - left < res[1] - res[0]){
                    res[0] = left;
                    res[1] = right;
                }
            }
        }
        return res[0] != 0 || res[1] != n ? s.substring(res[0], res[1] + 1) : "";
    }
}