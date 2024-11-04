package algorithm.stack;

import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 */
public class MyQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public MyQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        if(stack2.isEmpty()){
            dump();
        }
        return stack2.removeLast();
    }

    public int peek() {
        if(stack2.isEmpty()){
            dump();
        }
        return stack2.getLast();
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }
    public void dump(){
        while(!stack1.isEmpty()){
            stack2.add(stack1.removeLast());
        }
    }
}
