package n70.minStack;

import java.util.Objects;

public class MinStack {
    private Integer minVal;
    private final Node top;

    private static class Node {
        Integer Val;
        Node Next;
    }

    public MinStack() {
        top = new Node();
    }

    public void push(int val) {
        Node xNode = new Node();
        xNode.Val = val;
        xNode.Next = top.Next;
        top.Next = xNode;
        if (minVal == null || val < minVal) {
            minVal = val;
        }
    }

    public void pop() {
        if (top.Next == null) {
            return;
        }

        Node next = top.Next;
        top.Next = next.Next;
        if (next.Next == null) {
            minVal = null;
        } else if (Objects.equals(next.Val, minVal)) {
            Node node = top.Next;
            minVal = node.Val;
            while (node != null) {
                if (node.Val < minVal) {
                    minVal = node.Val;
                }
                node = node.Next;
            }
        }
    }

    public int top() {
        if (top.Next == null) {
            return -1;
        }

        return top.Next.Val;
    }

    public int getMin() {
        return minVal;
    }
}
