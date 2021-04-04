class Solution {
    public String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        final int length = chars.length;
        int startOfString = 0;
        int endOfString = length - 1;
        reverse(chars, startOfString, endOfString);
        while (chars[startOfString] == ' ' || chars[endOfString] == ' ') {
            if (chars[startOfString] == ' ') {
                startOfString++;
            }
            if (chars[endOfString] == ' ') {
                endOfString--;
            }
        }
        int slow = startOfString, fast = slow + 1;
        int startOfWord = slow, endOfWord = fast;
        boolean startOfWordFound = false, endOfWordFound = false;
        while (fast <= endOfString) {
            while (chars[slow] == ' ' && chars[fast] == ' ') {
                System.arraycopy(chars, fast, chars, fast - 1, endOfString - fast + 1);
                endOfString--;
            }
            if (!startOfWordFound && (slow == startOfString || (chars[slow] == ' ' && chars[fast] != ' '))) {
                startOfWord = (slow == startOfString) ? startOfWord : fast;
                startOfWordFound = true;
            }
            if (!endOfWordFound && (fast == endOfString || (chars[fast] == ' ' && chars[slow] != ' '))) {
                endOfWord = (fast == endOfString) ? endOfString : slow;
                endOfWordFound = true;
            }
            if (startOfWordFound && endOfWordFound) {
                reverse(chars, startOfWord, endOfWord);
                startOfWordFound = false;
                endOfWordFound = false;
            }
            fast++;
            slow++;
        }
        return new String(chars, startOfString, endOfString - startOfString + 1);
    }

    private void reverse(char[] chars, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            final char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
