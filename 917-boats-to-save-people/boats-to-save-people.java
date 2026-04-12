class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
int j=people.length-1;
int boats=0;
while(i<=j){
    int rem=limit-people[j];
    if(people[i]<=rem){
        i++;
    }
    boats++;
    j--;
}
return boats;
    }
}