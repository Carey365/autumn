package algorithm.stack;

import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty() || s.charAt(i)!=stack.getLast()){
                stack.add(s.charAt(i));
            }
            else{
                stack.removeLast();
            }
        }
        StringBuilder ans=new StringBuilder();
        for(Character o:stack){
            ans.append(o);
        }
        return ans.toString();
    }
}
