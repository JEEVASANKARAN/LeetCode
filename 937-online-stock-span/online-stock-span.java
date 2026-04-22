class StockSpanner {
Deque<int[]> dq;
    public StockSpanner() {
        dq=new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!dq.isEmpty()&&price>=dq.peekLast()[0]){
            span+=dq.pollLast()[1];
        }
        dq.offerLast(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */