package algorithm.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 */
public class IsValid {
    public boolean isValid(String s) {
        LinkedList<Character> list =new LinkedList<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(map.containsKey(ch) && list.size()>0){
                char cur = list.removeLast();
                if(cur != map.get(ch)){
                    return false;
                }
            }
            else{
                list.add(ch);
            }
        }
        return list.size()==0?true:false;
    }
}
