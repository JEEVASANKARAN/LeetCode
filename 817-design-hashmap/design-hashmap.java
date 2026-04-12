class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] bucket;
    private int size = 769; // prime number reduces collisions

    public MyHashMap() {
        bucket = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node curr = bucket[index];

        if (curr == null) {
            bucket[index] = new Node(key, value);
            return;
        }

        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = bucket[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = bucket[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    bucket[index] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}