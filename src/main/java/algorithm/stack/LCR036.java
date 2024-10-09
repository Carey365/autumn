package algorithm.stack;
import java.util.*;

/**
 *  LCR 036. 逆波兰表达式求值
 */
public class LCR036 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int num1 = list.removeLast();
                int num2 = list.removeLast();
                list.add(num2+num1);
            }
            else if(tokens[i].equals("-")){
                int num1 = list.removeLast();
                int num2 = list.removeLast();
                list.add(num2-num1);
            }
            else if(tokens[i].equals("*")){
                int num1 = list.removeLast();
                int num2 = list.removeLast();
                list.add(num2*num1);
            }
            else if(tokens[i].equals("/")){
                int num1 = list.removeLast();
                int num2 = list.removeLast();
                list.add(num2/num1);
            }
            else{
                list.add(Integer.parseInt(tokens[i]));
            }
        }
        return list.getLast();
    }
}
