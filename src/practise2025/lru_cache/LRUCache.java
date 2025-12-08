package practise2025.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // 最大容量
    private final int capacity;

    private Map<Integer, CacheNode> map = new HashMap<>();
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {

        CacheNode node = this.map.get(key);
        if (node != null) {
            delete(key);
        }
        addToHead(key, value);
        if (this.map.size() > this.capacity) {
            delete(this.tail.getKey());
        }
    }

    public int get(int key) {
        CacheNode node = this.map.get(key);
        if (node == null) {
            return -1;
        }

        delete(key);

        addToHead(key, node.getValue());

        return node.getValue();
    }


    private void delete(int key) {
        CacheNode node = this.map.get(key);
        if (node == null) {
            return;
        }
        if (this.map.size() == 1) {
            this.head = null;
            this.tail = null;
        } else if (node == this.head) {
            this.head = this.head.getNextNode();
            this.head.setPreNode(null);
        } else if (node == this.tail) {
            this.tail = node.getPreNode();
            this.tail.setNextNode(null);
        } else {
            node.getPreNode().setNextNode(node.getNextNode());
            node.getNextNode().setPreNode(node.getPreNode());
        }

        this.map.remove(key);
    }

    private void addToHead(int key, int value) {
        CacheNode node = new CacheNode(key, value);
        if (this.map.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNextNode(this.head);
            this.head.setPreNode(node);
            this.head = node;
        }
        this.map.put(key, node);
    }


    static class CacheNode {

        private int key;

        private int value;

        private CacheNode preNode;
        private CacheNode nextNode;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public CacheNode getPreNode() {
            return preNode;
        }

        public void setPreNode(CacheNode preNode) {
            this.preNode = preNode;
        }

        public CacheNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(CacheNode nextNode) {
            this.nextNode = nextNode;
        }
    }

}
