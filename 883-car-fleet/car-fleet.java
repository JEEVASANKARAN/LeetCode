class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> map=new HashMap<>();
        for(int i=0;i<position.length;i++){
            map.put(position[i],(double)(target-position[i])/speed[i]);
        }
        Arrays.sort(position);
        int fleet=0;
        double lastTime=0;
        for(int i=position.length-1;i>-1;i--){
            double currentTime=map.get(position[i]);
            if(currentTime>lastTime){
                fleet++;
                lastTime=currentTime;
            }
        }
        return fleet;
    }
}