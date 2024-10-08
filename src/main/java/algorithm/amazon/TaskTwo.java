package algorithm.amazon;

public class TaskTwo {
    public int calculate(int m,int n){
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }

}
