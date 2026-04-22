class StockSpanner {
List<Integer> list;
    public StockSpanner() {
        list=new ArrayList<>();
    }
    
    public int next(int price) {
        int count=0;
        list.add(price);
        for(int i=list.size()-1;i>-1;i--){
            if(price>=list.get(i)) count++;
            else break;
        }
        return count;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */