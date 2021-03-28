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
        // 表示从根节点开始向下构建
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            // 判断p的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (son[p][u] == 0) 
                son[p][u] = ++idx;
            // 继续向下构建
            p = son[p][u];
        
        }

        // 以节点p结尾的字符串个数+1
        cnt[p]++;

    }
    
    public boolean search(String word) {
        
        char[] chs = word.toCharArray();
        // 从根节点开始向下进行构建
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            int u = chs[i] - 'a';
            // 判断p的子节点集合中是否已经存在了chs[i], 不存在则返回false
            if (son[p][u] == 0)
                return false;
            // 继续向下构建
            p = son[p][u];
        }

        // 是否存储以节点p结尾的字符串
        return cnt[p] > 0;

    }
    
    public boolean startsWith(String prefix) {

        char[] chs = prefix.toCharArray();
        // 从根节点开始向下进行构建
        int p = 0;
        for (int i = 0; i < chs.length; i++) {
            int u = chs[i] - 'a';
            // 判断p的子节点集合中是否已经存在了chs[i], 不存在则返回false
            if (son[p][u] == 0)
                return false;
            // 继续向下构建
            p = son[p][u];
        }

        // 存在以prefix为前缀的字符串
        return true;

    }
}

//方案2 消除二进制末尾的 1

class Trie {

    // 构造Trie树节点
    class TrieNode {

        // 标识该节点是否是字符串的结束节点
        boolean isEnd = false;
        // 当前节点的孩子节点
        TrieNode[] next = new TrieNode[26];

        // 设置当前节点为一个字符串的结束节点
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

        // 当前TrieNode节点是一个字符串的结尾
        node.setIsEnd(true);

    }
    
    public boolean search(String word) {
        
        char[] chs = word.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null) 
                return false;
            // 继续向下构建
            node = node.next[u];
        
        }

        // 当前TrieNode节点是否一个字符串的结尾
        return node.isEnd;

    }
    
    public boolean startsWith(String prefix) {

        char[] chs = prefix.toCharArray();
        // 表示从根节点开始向下构建
        TrieNode node = root;
        for (int i = 0; i < chs.length; i++) {
            
            int u = chs[i] - 'a';
            // 判断node的子节点集合中是否已经存在了chs[i], 不存在则创建
            if (node.next[u] == null) 
                return false;
            // 继续向下构建
            node = node.next[u];
        
        }

        // 前缀查找成功
        return true;

    }
}
