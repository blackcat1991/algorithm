//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 106 
// 最多调用 104 次 put、get 和 remove 方法 
// 
//
// 
//
// 进阶：你能否不使用内置的 HashMap 库解决此问题？ 
// Related Topics 设计 哈希表 
// 👍 172 👎 0


package com.bobohe.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

//Java：设计哈希映射
public class P706DesignHashmap{
    public static void main(String[] args) {
        //Solution solution = new P706DesignHashmap().new Solution();
        // TO TEST
        //new HashMap<>()
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    int BASE = 1000;
    LinkedList<Node<Integer,Integer>>[] nodesArr = null;

    private class Node<K,V>{
        int hash;
        K key;
        V value;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public int getHash() {
            return key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodesArr = new LinkedList[BASE];
        for (int i = 0; i < nodesArr.length; i++) {
            nodesArr[i] = new LinkedList<Node<Integer,Integer>>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node<Integer,Integer> node = new Node<>(key,value);
        int hash = hash(node.getHash());
        LinkedList<Node<Integer,Integer>> nodes = nodesArr[hash];
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getKey() == key) {
                nodes.get(i).setValue(value);
                return;
            }
        }
        nodes.add(node);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(Integer.hashCode(key));
        LinkedList<Node<Integer,Integer>> nodes = nodesArr[hash];
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getKey() == key) {
                return nodes.get(i).getValue();
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(Integer.hashCode(key));
        LinkedList<Node<Integer,Integer>> nodes = nodesArr[hash];
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getKey() == key) {
                nodes.remove(i);
            }
        }
    }

    private int hash(int hash) {
        return hash%BASE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}