package algorithm.dynamicProgramming;
import java.util.*;

/**
 *  139. 单词拆分
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(wordDict.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(dp[j-1] && wordDict.contains(s.substring(j,i+1))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
