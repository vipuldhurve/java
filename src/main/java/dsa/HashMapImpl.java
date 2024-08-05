package dsa;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //No. of nodes
        private int N; //buckets.length

        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(int N) {
            this.n = 0;
            this.N = N;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < this.buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int code = key.hashCode();
            return Math.abs(code) % this.N;
        }

        private int SearchInLL(int bi, K key) {
            LinkedList<Node> list = this.buckets[bi];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBuckets[] = this.buckets;
            this.N = this.N * 2;
            this.buckets = new LinkedList[this.N];

            for (int i = 0; i < this.buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> list = oldBuckets[i];
                for (int j = 0; j < list.size(); j++) {
                    Node node = list.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); //bucket index
            int di = SearchInLL(bi, key); //data index

            if (di == -1) {
                //if key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                //if key exist
                buckets[bi].get(di).value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); //bucket index
            int di = SearchInLL(bi, key); //data index

            if (di == -1) {
                //if key doesn't exist
                return null;
            } else {
                //if key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key); //bucket index
            int di = SearchInLL(bi, key); //data index

            if (di == -1) {
                //if key doesn't exist
                return false;
            } else {
                //if key exist
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); //bucket index
            int di = SearchInLL(bi, key); //data index

            if (di == -1) {
                //if key doesn't exist
                return null;
            } else {
                //if key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keyset() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < this.buckets.length; i++) {
                LinkedList<Node> list = this.buckets[i];
                for (int j = 0; j < list.size(); j++) {
                    Node node = list.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(4);
        map.put("India", 1500);
        map.put("USA", 500);
        map.put("China", 2000);

        System.out.println("Size = " + map.size());

        System.out.println("----------------");
        ArrayList<String> keys = map.keyset();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println("----------------");
        map.remove("India");
        System.out.println("Does map contains key \"India\"? => " + map.containsKey("India"));
    }

}
