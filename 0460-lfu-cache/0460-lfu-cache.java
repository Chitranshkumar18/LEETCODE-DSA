class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size = 0;

        DoublyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLFU() {
            Node node = head.next;
            remove(node);
            return node;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, DoublyLinkedList> freqMap = new HashMap<>();

    int capacity;
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (map.size() == capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node removed = list.removeLFU();
            map.remove(removed.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);

        freqMap.putIfAbsent(1, new DoublyLinkedList());
        freqMap.get(1).add(node);

        minFreq = 1;
    }

    void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).add(node);
    }
}