1class Pair{
2        String value;
3        int timeStamp;
4        public Pair(String value,int timeStamp){
5            this.value=value;
6            this.timeStamp=timeStamp;
7        }
8}
9class TimeMap {
10    
11    Map<String,List<Pair>> map;
12    public TimeMap() {
13        map=new HashMap<>();
14    }
15    
16    public void set(String key, String value, int timeStamp) {
17        map.putIfAbsent(key,new ArrayList<>());
18        map.get(key).add(new Pair(value,timeStamp));
19    }
20    
21    public String get(String key, int timeStamp) {
22        if(!map.containsKey(key)) return "";
23        List<Pair> list=map.get(key);
24        return bs(list,timeStamp);
25    }
26    public String bs(List<Pair> list,int timeStamp){
27        String ans="";
28        int left=0;
29        int right=list.size()-1;
30        while(left<=right){
31            int mid=left+(right-left)/2;
32            if(list.get(mid).timeStamp<=timeStamp){
33                left=mid+1;
34                ans=list.get(mid).value;
35            }else{
36                right=mid-1;
37            }
38        }
39        return ans;
40    }
41}
42
43/**
44 * Your TimeMap object will be instantiated and called as such:
45 * TimeMap obj = new TimeMap();
46 * obj.set(key,value,timestamp);
47 * String param_2 = obj.get(key,timestamp);
48 */