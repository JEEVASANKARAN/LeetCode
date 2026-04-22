class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] db=new double[n][2];
        for(int i=0;i<n;i++){
            db[i][0]=position[i];
            db[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(db,(a,b)->Double.compare(b[0],a[0]));

        int fleat=0;
        double currentMax=0;

        for(int i=0;i<n;i++){
            if(db[i][1]>currentMax){
                fleat++;
                currentMax=db[i][1];
            }
        }
        return fleat;
    }
}