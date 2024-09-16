package algorithm.stack;

import java.util.LinkedList;

/**
 * 栈
 */
public class Stack {
    LinkedList<Integer> list = new LinkedList<>();

    public void add(int num) {
        list.add(num);
    }

    public int pop(int num) {
        return list.removeLast();
    }

    public int peek() {
        return list.getLast();
    }
}
