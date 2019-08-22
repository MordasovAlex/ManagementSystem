package com.mmu.algorithm;
import java.util.*;

public class SecondChance<K,V> extends AbstractAlgoCache<K,V>{
	private LinkedHashMap<K,V> map;
	private Queue<Boolean> Rbit;
	
	public SecondChance(int capacity) {
		super(capacity);
		this.map = new LinkedHashMap<>();
		Rbit=new LinkedList<Boolean>(); 
		for(boolean a : Rbit)
			a=false;
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
	    	
	    }
	    map.put(key, value);
	    return value;
		}

	
	public void removeElement(K key) {
		this.map.remove(key);
	}

}
