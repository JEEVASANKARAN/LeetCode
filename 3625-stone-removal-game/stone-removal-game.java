class Solution {
    public boolean canAliceWin(int n) {
        
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