package com.hit.algorithm;

import java.util.*;



public class SecondChance<K,V> extends AbstractAlgoCache<K,V>
{

	private LinkedHashMap<K, V> map;
	private HashMap<K, Integer> hashMap;
	K last_key;
	
	public SecondChance(int capacity) {
		super(capacity);
		this.map = new LinkedHashMap<>();
		this.hashMap = new HashMap<>();
	}
	
	public V getElement(K key) {
	    V value = this.map.get(key);
        if (value == null)
        return null;
        else 
        return value;
	}
	
	public void removeElement(K key) {
		this.map.remove(key);
	}	
	
	public V putElement(K key, V value) {
		V element = null;
		boolean elementNotAdded = true;
		
		if(!map.containsKey(key)) {
			
			if(this.map.size() == this.getCapacity()) {
				Iterator<Map.Entry<K, V>> entryToCheck = this.map.entrySet().iterator();
				
				while(entryToCheck.hasNext()) {
					if(entryToCheck.next().getKey().equals(last_key)) {
						if(!entryToCheck.hasNext()) {
							entryToCheck = map.entrySet().iterator();
						}
					break;	
					}
					
				}
				while(entryToCheck.hasNext() && elementNotAdded) {
					K entryKey = entryToCheck.next().getKey();
					if(hashMap.get(entryKey).equals(1)) {
						hashMap.remove(entryKey);
						hashMap.put(entryKey, 0);
					}
					else{
						element = map.remove(entryKey);
						hashMap.remove(entryKey);
						map.put(key, value);
						hashMap.put(key, 0);
						elementNotAdded = false;
					}
					if(!entryToCheck.hasNext())
						entryToCheck = map.entrySet().iterator();
				}
			}
			else {
				map.put(key, value);
				hashMap.put(key, 0);
			}
		}
		else {
			hashMap.remove(key);
			hashMap.put(key, 1);
		}
		last_key = key;
		return element;
	}
	
}