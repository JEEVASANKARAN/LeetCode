class MinStack {
private Deque<Integer> stack;
private Deque<Integer> minStack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerLast(val);
        if(minStack.isEmpty()||val<=minStack.peekLast()) minStack.offerLast(val);
    }
    
    public void pop() {
        if(stack.peekLast().equals(minStack.peekLast())) minStack.pollLast();
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */