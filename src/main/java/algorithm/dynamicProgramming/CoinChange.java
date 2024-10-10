package algorithm.dynamicProgramming;

/**
 *  322. 零钱兑换
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j>=coins[i] && dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
