package com.mmu.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class RandomAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {

	 private LinkedHashMap<K,V> map;
	
	public RandomAlgoCacheImpl(int capacity) {
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
    if (this.map.size() == this.capacity) {
    	int rnd=new Random().nextInt(map.keySet().size());
    	K temp = new ArrayList<>(map.keySet()).get(rnd);
    	map.remove(temp);
        }
    map.put(key, value);
    return value;
	}

	
	
	public void removeElement(K key) {
		this.map.remove(key);
		
	}    

}
