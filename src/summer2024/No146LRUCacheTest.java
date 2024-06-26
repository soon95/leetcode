package summer2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leon Song
 * @date 6/26/24
 */
public class No146LRUCacheTest {

    public static void main(String[] args) {


        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);

        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }


}


class LRUCache {

    int capacity;
    int count;
    LRUCacheNode head;
    LRUCacheNode tail;

    Map<Integer, LRUCacheNode> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new LRUCacheNode(-10, -10);
        this.tail = new LRUCacheNode(-100, -100);
        head.nextNode = tail;
        tail.preNode = head;

        this.map = new HashMap<>();
    }

    public int get(int key) {
        LRUCacheNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        this.refresh(node);

        return node.value;

    }

    public void put(int key, int value) {

        LRUCacheNode node = map.get(key);
        if (node != null) {
            node.value = value;
            this.refresh(node);
        } else {

            node = new LRUCacheNode(key, value);
            this.map.put(key, node);
            this.addAhead(node);


            if (count < capacity) {
                this.count++;
            } else {
                LRUCacheNode removeNode = tail.preNode;
                this.map.remove(removeNode.key);
                this.remove(removeNode);
            }

        }


    }

    /**
     * 刷新一下元素
     */
    private void refresh(LRUCacheNode curNode) {
        this.remove(curNode);
        this.addAhead(curNode);
    }

    /**
     * 移除某个元素
     */
    private void remove(LRUCacheNode curNode) {
        if (curNode == null) {
            return;
        }

        LRUCacheNode next = curNode.nextNode;
        LRUCacheNode pre = curNode.preNode;

        // 如果当前节点在中间
        pre.nextNode = next;
        next.preNode = pre;
    }


    /**
     * 将元素追加到头部
     */
    private void addAhead(LRUCacheNode curNode) {

        LRUCacheNode headNext = head.nextNode;

        head.nextNode = curNode;
        curNode.preNode = head;

        curNode.nextNode = headNext;
        headNext.preNode = curNode;
    }
}


class LRUCacheNode {
    int key;
    int value;

    LRUCacheNode preNode;
    LRUCacheNode nextNode;

    public LRUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}