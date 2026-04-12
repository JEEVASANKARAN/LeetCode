class Solution {
    public int subtractProductAndSum(int n) {
    int sum=digitSum(n);
    int prd=digitPrd(n);
    return prd-sum;
    }
    private int digitSum(int num1){
    int s1=0;
    while(num1>0){
    s1+=num1%10;
    num1=num1/10;
    }
    return s1;
    }
    private int digitPrd(int num2){
    int s2=1;
    while(num2>0){
    s2=s2*(num2%10);
    num2=num2/10;
    }
    return s2;
    }
}