package com.hit.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class RandomAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {

	 private LinkedHashMap<K,V> map;

	public RandomAlgoCacheImpl(int capacity) {
		super(capacity);
		this.map = new LinkedHashMap<>();
	} 
	@Override
	public V getElement(K key) {
	    V v = this.map.get(key);
        if (v == null) return null;
        else return v;
	
	}
	
	@Override
	public V putElement(K key, V value) {
		V val = null;
	    if (this.map.size() == this.getCapacity()) {
	    	int rnd=new Random().nextInt(map.keySet().size());
	    	K temp = new ArrayList<>(map.keySet()).get(rnd);
	    	val = getElement(temp);
	    	map.remove(temp);
	        }
	    map.put(key, value);
	    return val;
		}
	
	@Override
	public void removeElement(K key) {
		this.map.remove(key);
		
	}    
	
}	
