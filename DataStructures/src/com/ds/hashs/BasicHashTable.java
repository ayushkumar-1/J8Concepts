package com.ds.hashs;

public class BasicHashTable<X, Y> {

	//Array of HashEntry
	private HashEntry[] data;
	private int capacity;
	private int size;
	
	
	//Constructor
	public BasicHashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[capacity];
		this.size = 0;
	}
	
	//size
	public int size(){
		return this.size;
	}
	
	//get Key
	public Y get(X key) {
		int hash = calculateHash(key);
		//If the data array, doesn't have anything for that key
		if(null == data[hash]) {
			return null;
		}
		//else return the data value --> the hashentry for the key and return its value
		return (Y)data[hash].getValue();
	}
	
	//put
	public void put(X x, Y y) {
		int hash = calculateHash(x);
		data[hash] = new HashEntry<X, Y>(x, y);
		size++;
	}
	
	//delete
	public Y delete(X x) {
		//first: get the value for the key
		Y value = get(x);
		//clear out the hashtable slot for the key and return the removed value
		if(null != value) {	
			int hash = calculateHash(x);
			data[hash] = null;
			size--;
			hash = (hash+1)%this.capacity;
			//If next slot isn't empty we should re add it so that we can keep the hash algorithm, clean
			while(data[hash] != null) {
				HashEntry he = data[hash];
				data[hash] = null;
				put((X)he.getKey(), (Y)he.getValue());
				//the data is repositioned and no new data is added so size should be reduced
				size--;
				//See if there is another collision
				hash = (hash+1)%this.capacity;
			}		
		}
		
		return value;

	}
	
	//hasKey
	public boolean hasKey(X x) {
		int hash = calculateHash(x);
		if(null != data[hash] && data[hash].getKey().equals(x)) {
			return true;
		}
		return false;
	}
	
	//hasValue
	public boolean hasValue(Y y) {
		for(int i = 0; i < this.capacity; i++) {
			if(null != data[i] && data[i].getValue().equals(y)) {
				return true;
			}			
		}
		return false;
	}
	
	
	//calculate Hash
	private int calculateHash(X key) {
		
		//find the space in the array data --> hash slot
		int hash = (key.hashCode() % this.capacity);
		//if same slot, check for hash collision
		while(null != data[hash] && !data[hash].getKey().equals(key)) {
			hash = (hash+1) % this.capacity;
		}
		
		return hash;
	}
	
	
	//HashEntry for key and value
	private class HashEntry<X, Y>{
		
		private X key;
		private Y value;
		
		//Constructor
		public HashEntry(X x, Y y) {
			this.key = x;
			this.value = y;
		}
		
		public X getKey() {
			return key;
		}
		public Y getValue() {
			return value;
		}
		
	}
	
	
}
