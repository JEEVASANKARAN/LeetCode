class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;

        int amount = 10;
        boolean turn = false;


        while(n >= amount){
            n -= amount;
            amount--;
            turn = !turn;
        }
        
        return turn;
    }
}