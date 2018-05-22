package com.ds.lists;

public class BasicLinkedList<E> {

	private Node firstNode;
	private Node lastNode;
	private int nodeCount;
	
	//constructor
	public BasicLinkedList() {
		firstNode = null;
		lastNode = null;
		nodeCount = 0;
	}
	
	public void add(E data) {
		//if the first item is added
		if(null == firstNode) {
			firstNode = new Node(data);
			lastNode = firstNode;
		}
		else {
			Node newNode = new Node(data);
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
		nodeCount++;
	}
	
	public E remove() {

		if (null == firstNode) {
			throw new IllegalStateException("The List is empty. Nothing to remove.");
		}

		E removedNodeData = firstNode.getNodeItem();
		firstNode = firstNode.getNextNode();
		nodeCount--;
		return removedNodeData;

	}
	
	public E get(int position) {
		
		if(null == firstNode || size() < position) {
			throw new IllegalStateException("The List is empty or position is greater than the size of list");
		}
		
		Node current = firstNode;
		
		for(int i = 1; i < position; i++) {
			current = current.getNextNode();
		}
		
		return current.getNodeItem();
	}
	
	public int find(E data) {
		
		if(null == firstNode) {
			throw new IllegalStateException("The List is empty");
		}
		
		Node current= firstNode;
		
		for(int i = 0; i < size(); i++) {
			if(current.getNodeItem().equals(data)) {
				return i+1;
			}
			current = current.getNextNode();
		}
		
		//data not found
		return -1;
	}
	
	public void insert(E data, int position) {
		
		if(position > size()) {
			throw new IllegalStateException("LinkedList is smaller than position");
		}
		
		Node current = firstNode;
		int countPosition = 1;
		
		while(null != current && countPosition < position-1) {
			current = current.getNextNode();
			countPosition++;
		}
		//3->4->5 new:2, 3->2->4
		Node newNode = new Node(data);
		newNode.setNextNode(current.getNextNode());
		current.setNextNode(newNode);
		nodeCount++;
	}
	
	public void removeAt(int position) {
		if(null == firstNode || size() < position) {
			throw new IllegalStateException("Either the list is empty or the list size is smaller than position");
		}
		
		Node current = firstNode;
		int countPosition = 1;
		while(null != current && countPosition < position-1) {
			current = current.getNextNode();
			countPosition++;
		}
		
		Node nodeToRemove = current.getNextNode();
		current.setNextNode(nodeToRemove.getNextNode());
		nodeToRemove = null; //for gc
		nodeCount--;
		
	}
	
	public int size() {
		return nodeCount;
	}
	
	@Override
	public String toString() {
		Node current = firstNode;
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("[{");
		while(null != current) {
			strBuild.append(current.getNodeItem());
			if(null != current.getNextNode()) {
				strBuild.append(",");
			}
			current = current.getNextNode();
		}
		strBuild.append("}]");
		
		return strBuild.toString();
	}
	
	private class Node{
		private Node nextNode;
		private E data;
		
		//constructor
		public Node(E data) {
			this.nextNode = null;
			this.data = data;
		}
		
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		public E getNodeItem() {
			return data;
		}
		
		
	}
	
}
