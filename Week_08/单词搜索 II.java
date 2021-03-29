class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        if (board.length==0 || board[0].length==0 || words.length==0) {
            return new ArrayList<String>(res);
        }
        for (String word : words) {
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (res.contains(word)) continue;
                    if (word.length()==1) {
                        String s = String.valueOf(board[i][j]);
                        if (word.equals(s)) {
                            res.add(word);
                            continue;
                        }
                    }
                // word首字母与board中字符相同时，进入dfs
                    if (board[i][j]==word.charAt(0)) {
                        visited[i][j] = true;
                        dfs(board, res, visited, i, j, word, 0);
                        visited[i][j] = false;
                    }
                }
            }
        }
        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, Set<String> res, boolean[][] visited, int i, int j, String word,int pos) {
        if (board[i][j] != word.charAt(pos)) return;
        if ((pos+1)==word.length()) {
            res.add(word);
            return;
        }
        // 方向搜索二维数组
        int [][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int [] dir : direction) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi>-1 && newj>-1 && newi<board.length && newj<board[0].length && !visited[newi][newj]) {
                visited[newi][newj] = true;
                dfs(board,res,visited,newi,newj,word,pos+1);
                visited[newi][newj] = false;
            }
        }

    }
    

}