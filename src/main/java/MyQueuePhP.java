import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueuePhP {

    int capacity;
    Map<String, Queue> map;
    Map<String, Set<Object>> registry;

    Lock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();
    Condition isFull = lock.newCondition();


    public MyQueuePhP(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.registry = new HashMap<>();
    }

    public void produce(String partitionId, String msg) {
        if (map.containsKey(partitionId)) {
            Queue<String> q = map.get(partitionId);
            if (q.size() < capacity) {
                q.offer(msg);
                Set<Object> consumers = registry.get(partitionId);
                // consumers
                for(Object consumer: consumers){
                    consume(partitionId, consumer);
                }
            }
        }
    }

    public String consume(String partitionId, Object user) {
        if (map.containsKey(partitionId) && registry.containsKey(partitionId) && registry.get(partitionId).contains(user)) {
            Queue<String> q = map.get(partitionId);
            if (!q.isEmpty()) {
                System.out.println("Consumed msg! User: " + user + "  part: " + partitionId);
                return q.poll();
            }
        }
        return null;
    }

    public void register(Object user, String partitionId) {
        if (registry.containsKey(partitionId)) registry.get(partitionId).add(user);
        else {
            Set<Object> users = new HashSet<>();
            users.add(user);
            registry.put(partitionId, users);
            map.put(partitionId, new LinkedList());
        }
    }

    public static void main(String[] args) {
        MyQueuePhP queue = new MyQueuePhP(4);
        String partitionId = "part1";
        Object producer = new Object();
        Object consumer1 = new Object();
        Object consumer2 = new Object();
        queue.register(consumer1, partitionId);
        queue.register(consumer2, partitionId);
        queue.produce("part1", "message123");
    }

    class BufferCapacityExceeded extends RuntimeException{
        String partitionId;
        String message;
        public BufferCapacityExceeded(String partitionId) {
            this.partitionId = partitionId;
            this.message = "Buffer Capacity is full for partition: " + partitionId;
        }
    }
}

