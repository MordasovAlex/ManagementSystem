package com.mmu.algorithm;


import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {
	 private LinkedHashMap<K,V> map;

	 
	
	public LRUAlgoCacheImpl(int capacity) {
		super(capacity);
		this.map = new LinkedHashMap<>();
	}

	public V getElement(K key) {
	    V value = this.map.get(key);
        if (value == null)
        return null;
        else 
        return value;
	}
	
	public V putElement(K key, V value) {
        if (this.map.containsKey(key)) {
        	this.map.remove(key);
        } else if (this.map.size() == this.capacity) {
            Iterator<K> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, value);
        return value;
    }

	public void removeElement(K key) {
		this.map.remove(key);
		
	}	
	

}
