package algorithm.stack;
import java.util.*;

/**
 * LCR 039. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] rights = new int[heights.length];
        int[] lefts = new int[heights.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        for(int i=1;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.getLast()]){
                rights[stack.removeLast()] = i;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            rights[stack.removeLast()] = heights.length;
        }
        stack.add(heights.length-1);
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i]<heights[stack.getLast()]){
                lefts[stack.removeLast()] = i;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            lefts[stack.removeLast()] = -1;
        }

        int ans =0;
        for(int i=0;i<heights.length;i++){
            int l = lefts[i]+1;
            int r = rights[i]-1;
            ans = Math.max(ans,heights[i]*(r-l+1));
        }
        return ans;
    }
}
