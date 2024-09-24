package algorithm.traceBack;

public class Point24 {
    boolean flag = false;
    double cur = Integer.MAX_VALUE;
    int count = 0;
    public boolean judgePoint24(int[] cards) {
        boolean[] searched = new boolean[cards.length];
        helper(cards,searched);
        return flag;
    }
    public void helper(int[] cards,boolean[] searched){
        if(count==4 && Math.abs(cur-24)<=1e-6){
            flag = true;
            return;
        }
        if(flag){
            return;
        }
        for(int i=0;i<cards.length;i++){
            if(searched[i]){
                continue;
            }
            searched[i] = true;
            if(count == 0){
                cur= cards[i];
                count++;
                helper(cards,searched);
                count--;
            }
            else{
                for(int j=0;j<4;j++){
                    if(j==0){
                        cur = cur+cards[i];
                        count++;
                        helper(cards,searched);
                        cur = cur-cards[i];
                        count--;
                    }
                    if(j==1){
                        cur = cur-cards[i];
                        count++;
                        helper(cards,searched);
                        cur = cur+cards[i];
                        count--;
                    }
                    if(j==2){
                        cur = cur * cards[i];
                        count++;
                        helper(cards,searched);
                        cur = cur/cards[i];
                        count--;
                    }
                    if(j==3){
                        cur = cur / cards[i];
                        count++;
                        helper(cards,searched);
                        cur = cur * cards[i];
                        count--;
                    }
                }
            }
            searched[i] = false;
        }
    }
}
