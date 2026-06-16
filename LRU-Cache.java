1class LRUCache {
2Map<Integer,Node> map;
3int size;
4int maxSize;
5Node dummyHead;
6Node dummyTail;
7
8    public LRUCache(int capacity) {
9        maxSize=capacity;
10        map=new HashMap<>();
11        dummyHead=new Node(0,0);
12        dummyTail=new Node(0,0);
13        dummyHead.next=dummyTail;
14        dummyTail.prev=dummyHead;
15    }
16    
17    public int get(int key) {
18        if(!map.containsKey(key)) return -1;
19        Node data=map.get(key);
20        moveToTail(data);
21        return data.value;
22    }
23    
24    public void put(int key, int value) {
25        if(!map.containsKey(key)){
26            if(size>=maxSize){
27                map.remove(dummyHead.next.key);
28                detach(dummyHead.next);
29                size--;
30            }
31            Node newNode=new Node(key,value);
32            addTail(newNode);
33            map.put(key,newNode);
34            size++;
35        } 
36        else {
37            Node node = map.get(key);
38            node.value = value;
39            moveToTail(node);
40        }
41
42    }
43    public void moveToTail(Node node){
44        detach(node);
45        addTail(node);
46    }
47    public void detach(Node node){
48        node.next.prev=node.prev;
49        node.prev.next=node.next;
50        node.prev=null;
51        node.next=null;
52    }
53    public void addTail(Node node){
54        Node prev=dummyTail.prev;
55
56        prev.next=node;
57        node.prev=prev;
58        
59        node.next=dummyTail;
60        dummyTail.prev=node;
61    }
62}
63class Node{
64    Node prev;
65    Node next;
66
67    int value;
68    int key;
69public Node(int key,int value){
70    this.key=key;
71    this.value=value;
72}
73}
74
75/**
76 * Your LRUCache object will be instantiated and called as such:
77 * LRUCache obj = new LRUCache(capacity);
78 * int param_1 = obj.get(key);
79 * obj.put(key,value);
80 */