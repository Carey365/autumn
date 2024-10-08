package algorithm.stack;
import java.util.*;

/**
 * 227. 基本计算器 II
 */
public class Calculator {
    public int calculate(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> signStack = new LinkedList<>();
        int index =0;
        while(index<s.length()){
            if(s.charAt(index)==' '){
                index++;
                continue;
            }
            if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                int value = 0;
                while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
                    value = value * 10 + (s.charAt(index)-'0');
                    index++;
                }
                if(!signStack.isEmpty() && (signStack.getLast()=='*' || signStack.getLast()=='/')){
                    char sign = signStack.removeLast();
                    int num = numStack.removeLast();
                    if(sign=='*'){
                        numStack.add(num * value);
                    }
                    else{
                        numStack.add(num / value);
                    }
                }
                else{
                    numStack.add(value);
                }
            }
            else{
                signStack.add(s.charAt(index));
                index++;
            }
        }
        while(!signStack.isEmpty()){
            int num1 = numStack.removeFirst();
            int num2 = numStack.removeFirst();
            char sign = signStack.removeFirst();
            if(sign=='+'){
                numStack.addFirst(num1 + num2);
            }
            else{
                numStack.addFirst(num1 - num2);
            }
        }
        return numStack.getFirst();
    }
}
