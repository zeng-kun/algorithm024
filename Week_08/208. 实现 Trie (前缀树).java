//方案1：数组实现
//
class Trie {

    int N = 100010;
    int[][] son = new int[N][26];
    int idx = 0;
    int[] cnt = new int[N];

    public Trie() {

    }
    
    public void insert(String word) {
        
        char[] chs = word.toCharArray();
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            if (son[p][u] == 0) 
                son[p][u] = ++idx;
            p = son[p][u];
        
        }

        cnt[p]++;

    }
    
    public boolean search(String word) {
        
        char[] chs = word.toCharArray();
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            int u = chs[i] - 'a';
            if (son[p][u] == 0)
                return false;
            p = son[p][u];
        }

        return cnt[p] > 0;

    }
    
    public boolean startsWith(String prefix) {

        char[] chs = prefix.toCharArray();
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            int u = chs[i] - 'a';
            if (son[p][u] == 0)
                return false;
            p = son[p][u];
        }

        return true;

    }
}

//方案2 消除二进制末尾的 1

class Trie {

    class TrieNode {

        boolean isEnd = false;
        TrieNode[] next = new TrieNode[26];

        public void setIsEnd (boolean isEnd) {
            this.isEnd = isEnd;
        }

    }

    // root为根节点
    TrieNode root;

    public Trie()  {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        char[] chs = word.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null) 
                node.next[u] = new TrieNode();
            // 继续向下构建
            node = node.next[u];
        
        }

        node.setIsEnd(true);

    }
    
    public boolean search(String word) {
        
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            if (node.next[u] == null) 
                return false;
            // 继续向下构建
            node = node.next[u];
        
        }

        return node.isEnd;

    }
    
    public boolean startsWith(String prefix) {

        char[] chs = prefix.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            if (node.next[u] == null) 
                return false;
            // 继续向下构建
            node = node.next[u];
        
        }

        // 前缀查找成功
        return true;

    }
}
