package algorithm.amazon;

import java.util.*;

public class TaskOne {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5,3,3,3,4,6);
        int time = 2;
        List<Integer> ans = searchDays(list,time);
        for(Integer n: ans){
            System.out.println(n);
        }
        System.out.println(searchBST(3));
        System.out.println(numDecoding("1111"));
    }
//    输入: 数组记录每天安保数量，时间间隔time
//    小偷去偷东西，输出一个list，保证之前time天到第i天每天安保数量递减，第i天到后面time天每天安保数量递增，保存i。
//    比如输入 security: [5,3,3,3,4,6]，time=2，输出[3,4]
    public static List<Integer> searchDays(List<Integer> list, int time) {
        List<Integer> ans = new ArrayList<>();
        if (time * 2 + 1 > list.size()) {
            return null;
        }
        int upCounts = 0;
        int downCounts = 0;
        boolean[] ups = new boolean[list.size()];
        boolean[] downs = new boolean[list.size()];
        //get ups and downs
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                upCounts++;
                downCounts = 0;
            } else if (list.get(i) < list.get(i - 1)) {
                downCounts++;
                upCounts = 0;
            } else {
                upCounts++;
                downCounts++;
            }
            if (upCounts >= time) {
                ups[i] = true;
            }
            if (downCounts >= time) {
                downs[i] = true;
            }
        }
        //get the result
        for (int i = 0; i < list.size() - time; i++) {
            if (downs[i] && ups[i + time]) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

//    输入n，输出1-n这些数可以组成的BST个数
    public static int searchBST(int n){
        int[] dp = new int[n+1];
        //initialize
        dp[0] = 1;
        dp[1] = 1;
        //dp progress
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += (dp[j-1]*dp[i-j]);
            }
        }
        return dp[n];
    }

//    1-26对应a-z，输入num，输出可以生成的字符串数量
    public static int numDecoding(String s) {
        //invalid input
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        // create dp array
        int[] dp = new int[s.length() + 1];
        //initialize
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        //dp progress
        for (int i = 2; i <= s.length(); i++) {
            // get one digit
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            // get two digit
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

}
