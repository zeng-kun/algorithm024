class Solution {
    //说实话，一开始看到这道题目的时候，我确实已经懵了，这跟我学过的知识有什么关系吗？完全不知道怎么建模，转化成算法来解决
    //作者：Krahets
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            //递归中止条件：
            //如果遍历到的点已经在边界之外或者本身就是水，直接返回
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
                return;
            }

            //本次循环要做的事情：将遍历到的点置为0，防止重复遍历
            grid[i][j] = '0';
            //遍历四周的点
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }


  