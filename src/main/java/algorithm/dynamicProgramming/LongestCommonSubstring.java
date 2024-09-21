package algorithm.dynamicProgramming;

public class LongestCommonSubstring {

    // 求两个字符串的最长公共子串
    public static String longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // 创建dp数组
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;  // 记录最长公共子串的长度
        int endIndex = 0;  // 记录最长公共子串在s1中的结束位置

        // 填充dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 更新最大长度和结束索引
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }

        // 提取最长公共子串
        return s1.substring(endIndex - maxLen + 1, endIndex + 1);
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int ans=0;
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "zbcdfg";

        String result = longestCommonSubstring(s1, s2);
        System.out.println("最长公共子串是: " + result);
        System.out.println("长度是: " + result.length());

        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};

        System.out.println("最长公共子数组长度为："+findLength(nums1,nums2));
    }
}

