package com.ds.queue;

public class BasicQueue<X> {
	
	private X[] data;
	
	private int front;
	private int end;
	
	//constructor no param
	public BasicQueue() {
		this(1000);
	}
	
	//constructor with params
	public BasicQueue(int capacity) {
		data = (X[]) new Object[capacity];
		//start with negative : as in array 0 signifies an entry but we want to specify that there is no entry as yet. 
		this.front = -1;
		this.end = -1;
	}
	
	//size
	public int size() {
		
		if(end == -1 && front == -1) {
			return 0;
		}
		
		return (end - front + 1);		
	}
	
	//enQueue
	public void enQueue(X item) {
		
		//Check if Queue has space to add data
		if(end+1 > data.length) {
			throw new IllegalStateException("The Queue is full!!");
		}
		
		if(front == -1) {
			front++;
		}
		data[++end] = item;
		
	}
	
	//deQueue
	public X deQueue() {
		X item = null;
		//if queue is empty throw exception
		if(size() == 0) {
			throw new IllegalStateException("The Queue is empty. Nothing to remove");
		}
		//else this is last item on the queue
		else if(front == end) {
			item = data[front];
			data[front] = null; //ready for gc
			front = -1;
			end = -1;
		}		
		//else adjust the front pointer and return the element
		else {
			item = data[front];
			data[front] = null;
			front++;
		}
		
		return item;
	}
	
	//contains
	public boolean contains(X item) {
		
		boolean found = false;
		
		if(size() == 0) {
			found = false;
		}
		int counter = front;
		while(counter < end) {
			if(data[counter].equals(item)) {
				found = true;
				break;
			}
			counter++;
		}
		
		return found;		
	}
	

}
