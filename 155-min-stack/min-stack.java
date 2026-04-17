class MinStack {
ListNode head;
int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
        head=null;
    }
    
    public void push(int val) {
        if(min>val){
            min=val;
        }
        head=new ListNode(head,val,min);
    }
    
    public void pop() {
        head = head.next;
        if(head == null){min = Integer.MAX_VALUE;}
        else {min = head.currentMin;}
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.currentMin;
    }
}
class ListNode{
    ListNode next;
    int currentMin;
    int val;
    public ListNode(){}
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(ListNode next,int val,int currentMin){
        this.next=next;
        this.val=val;
        this.currentMin=currentMin;
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