class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int prd = 1;
        int i = list.size() - 1;
        while(i > -1 && k-- > 0){
            prd *= list.get(i--);
            if(prd == 0) return 0;
            //System.out.println(prd);
        }
        return prd;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */