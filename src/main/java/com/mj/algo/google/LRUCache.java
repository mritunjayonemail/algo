package com.mj.algo.google;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
Implementation of LRU Cache
 */
public class LRUCache<K,V> {

    private ConcurrentLinkedQueue<K> concurrentLinkedQueue = new ConcurrentLinkedQueue<K>();

    private ConcurrentHashMap<K, V> concurrentHashMap = new ConcurrentHashMap<K, V>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock =  readWriteLock.readLock();

    private Lock writeLock =  readWriteLock.writeLock();

    int maxSize = 0;

    public LRUCache(int maxSize){
        this.maxSize = maxSize;
    }

    public V getElement(K k) {
        readLock.lock();
        try{
            if (!concurrentHashMap.containsKey(k)) {
                return null;
            } else {
                concurrentLinkedQueue.remove(k);
                V v = concurrentHashMap.get(k);
                concurrentLinkedQueue.add(k);
                return v;
            }
        }
        finally {
            readLock.unlock();
        }
    }

    public V removeElement(K k){
        writeLock.lock();
        try {
            if (!concurrentHashMap.containsKey(k)) {
                return null;
            } else {
                concurrentLinkedQueue.remove(k);
                V v = concurrentHashMap.remove(k);
                return v;
            }
        }
        finally{
            writeLock.unlock();
        }
    }

    public V addElement(K k, V v){
        writeLock.lock();
        try {
            if(concurrentHashMap.size() >= maxSize){
                //remove items
                K queueKey= concurrentLinkedQueue.poll();
                concurrentHashMap.remove(queueKey);
            }

            if(concurrentHashMap.containsKey(k)){
                concurrentLinkedQueue.remove(k);
            }
            concurrentHashMap.put(k, v);
            concurrentLinkedQueue.add(k);
            return v;
        }
        finally{
            writeLock.unlock();
        }
    }

    public static void main(String args[]){
        LRUCache<String, String> lruCache = new LRUCache<String, String>(5);
        lruCache.addElement("1", "MJ");
        lruCache.addElement("2", "Guddu");
        lruCache.addElement("3", "Santosh");
        lruCache.addElement("4", "Sujit");
        lruCache.addElement("5", "Ranjan");
        for (String k : lruCache.concurrentHashMap.keySet()) {
            System.out.println(lruCache.concurrentHashMap.get(k));
        }
        lruCache.getElement("1");
        System.out.println("-------");
        lruCache.addElement("6", "Bijesh");

        for (String k : lruCache.concurrentHashMap.keySet()) {
            System.out.println(lruCache.concurrentHashMap.get(k));
        }

    }


}
