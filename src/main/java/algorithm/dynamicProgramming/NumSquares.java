package algorithm.dynamicProgramming;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        if(n<4){
            return n;
        }
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=1;
        for(int i=5;i<=n;i++){
            dp[i]=dp[i-1]+1;
            for(int j=2;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
