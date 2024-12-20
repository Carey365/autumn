package algorithm.string.kmp;

/**
 *  28. 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    public int strStr1(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            if (j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }
}
