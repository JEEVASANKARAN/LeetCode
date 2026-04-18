class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = dq.pollLast();
                int a = dq.pollLast();
                
                if (s.equals("+")) dq.offerLast(a + b);
                else if (s.equals("-")) dq.offerLast(a - b);
                else if (s.equals("*")) dq.offerLast(a * b);
                else if (s.equals("/")) dq.offerLast(a / b);
            } else {
                dq.offerLast(Integer.parseInt(s));
            }
        }
        return dq.pollLast();
    }
}