class Solution {
	//方案一
    public boolean isValidSudoku1(char[][] board) {
        //如何保证每行每列只出现一次；
        //这个3x3又如何转化
        int[][] rol = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                //将字符串转化成数字
                int num = board[i][j]-'0';
                if(rol[i][num]==1){
                    return false;
                }
                if(col[j][num]==1){
                    return false;
                }
                if(box[(i/3)*3+j/3][num]==1){
                    return false;
                }
                rol[i][num]=1;
                col[j][num]=1;
                box[(i/3)*3+j/3][num]=1;
            }
        }
        return true;
    }

public boolean isValidSudoku2(char[][] board) {
        Map<Integer, Set<Integer>> row  = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                int idx = i / 3 * 3 + j / 3;
                if (!row.get(i).contains(c) && !col.get(j).contains(c) && !area.get(idx).contains(c)) {
                    row.get(i).add(c);
                    col.get(j).add(c);
                    area.get(idx).add(c);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //方案三
    public boolean isValidSudoku3(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], area = new boolean[9][9];        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                int idx = i / 3 * 3 + j / 3;
                if (!row[i][c] && !col[j][c] && !area[idx][c]) {
                    row[i][c] = col[j][c] = area[idx][c] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

