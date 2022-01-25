import java.util.*;

public class HashMap{

    public static class Hashmap<K, V>{
        private class HMNode{
            K key;
            V value;

            HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<HMNode>[] buckets;
        private int size;

        Hashmap(){
            initBuckets(4);
            this.size = 0;
        }

        private void initBuckets(int N){
            this.buckets = new LinkedList[N];
            for(int bi = 0; bi < N; bi++){
                this.buckets[bi] = new LinkedList<>();
            }
        }

        private int hashfn(K key){
            int hc = key.hashCode();
            return hc % buckets.length;
        }

        private int getIndexWithinBucket(int bi, K key){
            int di = 0;
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;

        }

        public  void rehashing() throws Exception{
            LinkedList<HMNode>[] ob = this.buckets;

            initBuckets(2* ob.length);
            this.size = 0;
            for(int i = 0; i < ob.length; i++){
                for(HMNode node : ob[i]){
                    put(node.key, node.value);
                }
            }
            
        }

        public void put(K key, V value){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(bi, key);

            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = buckets.length * 1.0 % size;
            if(lambda > 2.0){
               try{
                    rehashing();
               }catch(Exception e){
                   System.out.println(e);
               }
            } 
        }

        public boolean containsKey(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(bi, key);

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(bi, key);

            if(di != -1){
               HMNode node = buckets[bi].get(di);
               return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashfn(key);
            int di = getIndexWithinBucket(bi, key);

            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                return null;
            }
        }

        public int size(){
            return this.size;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> res = new ArrayList<>();
            for(int i = 0; i < buckets.length; i++){
                for(HMNode node : buckets[i]){
                    res.add(node.key);
                }
            }
            return res;
        }

    }

    public static void main(String[] args){
        Hashmap<String, Integer> map = new Hashmap<>();
        System.out.println(map.size());
        System.out.println(map.remove("aman"));
        map.put("aman", 10);
        map.put("pawan", 20);
        map.put("ram", 30);
        System.out.println(map.size());
        System.out.println(map.remove("aman"));
        System.out.println(map.size());

    }
}