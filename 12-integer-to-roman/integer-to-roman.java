class Solution {
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thos[] = {"","M","MM","MMM"};
        
        return thos[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
}