1
2class LFUCache {
3
4    int capacity;
5    int minFreq;
6
7    Map<Integer, Node> nMap;
8    Map<Integer, DDL> fMap;
9
10    public LFUCache(int capacity) {
11        this.capacity = capacity;
12        this.minFreq = 0;
13
14        nMap = new HashMap<>();
15        fMap = new HashMap<>();
16    }
17
18    public int get(int key) {
19
20        if (!nMap.containsKey(key))
21            return -1;
22
23        Node node = nMap.get(key);
24        updateFrequency(node);
25        return node.value;
26    }
27
28    public void put(int key, int value) {
29
30        if (capacity == 0)
31            return;
32        if (nMap.containsKey(key)) {
33            Node node = nMap.get(key);
34            node.value = value;
35            updateFrequency(node);
36            return;
37        }
38
39        if (nMap.size() == capacity) {
40            DDL bucket = fMap.get(minFreq);
41            Node victim = bucket.removeLRU();
42            nMap.remove(victim.key);
43        }
44
45        Node node = new Node(key, value);
46        minFreq = 1;
47        DDL bucket = fMap.getOrDefault(1, new DDL());
48        bucket.addTail(node);
49        fMap.put(1, bucket);
50        nMap.put(key, node);
51    } 
52
53    private void updateFrequency(Node node) {
54
55        int oldFreq = node.freq;
56        DDL oldBucket = fMap.get(oldFreq);
57        oldBucket.detach(node);
58
59        if (oldFreq == minFreq && oldBucket.size == 0) {
60            minFreq++;
61        }
62
63        node.freq++;
64        DDL newBucket = fMap.getOrDefault(node.freq, new DDL());
65        newBucket.addTail(node);
66        fMap.put(node.freq, newBucket);
67    }
68}
69
70class DDL {
71
72    int size;
73
74    Node dummyHead;
75    Node dummyTail;
76
77    public DDL() {
78
79        dummyHead = new Node(0, 0);
80        dummyTail = new Node(0, 0);
81
82        dummyHead.next = dummyTail;
83        dummyTail.prev = dummyHead;
84    }
85
86    public void addTail(Node node) {
87
88        Node prev = dummyTail.prev;
89
90        prev.next = node;
91        node.prev = prev;
92
93        node.next = dummyTail;
94        dummyTail.prev = node;
95        size++;
96    }
97
98    public void detach(Node node) {
99
100        node.prev.next = node.next;
101        node.next.prev = node.prev;
102
103        node.prev = null;
104        node.next = null;
105        size--;
106    }
107
108    public Node removeLRU() {
109
110        Node node = dummyHead.next;
111        detach(node);
112        return node;
113    }
114}
115
116class Node {
117
118    int key;
119    int value;
120    int freq;
121
122    Node prev;
123    Node next;
124
125    public Node(int key, int value) {
126        this.key = key;
127        this.value = value;
128        this.freq = 1;
129    }
130}
131/**
132 * Your LFUCache object will be instantiated and called as such:
133 * LFUCache obj = new LFUCache(capacity);
134 * int param_1 = obj.get(key);
135 * obj.put(key,value);
136 */