package com.ds.tree;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;
	
	//Constructor
	public BasicBinaryTree() {
		this.root = new Node(null);
	}
	
	//size
	public int size() {
		return this.size;
	}
	
	//add
	public void add(X item) {
		
		Node node = new Node(item);
		//for empty tree
		if(null != root) {
			root = node;
			size++;
		}
		else {
			insert(this.root, node);
		}
		
	}
	
	//contains
	public boolean contains(X item) {
		
		if(null == root) {
			throw new IllegalStateException("The Tree is empty.");
		}	
		return contains(this.root, item);
	}
	
	
	//delete
	public void delete(X item) {
		
	}
	
	//unlink
	private void unlink(Node currentNode, Node newNode) {
		//if the currentNode is root to be replaced.
		if(currentNode == root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			root = newNode;
		}else if(currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		}else if(currentNode.getParent().getLeft() == currentNode) {
			currentNode.getParent().setLeft(newNode);
		}

	}
	
	private boolean contains(Node node, X item) {
		
		if(item.compareTo(node.getItem()) == 0) {
			return true;
		}else if(item.compareTo(node.getItem()) < 0 && null != node.getLeft() && contains(node.getLeft(), (X)node.getItem())){
			return true;
		}else if(item.compareTo(node.getItem()) > 0 && null != node.getRight() && contains(node.getRight(), (X)node.getItem())){
			return true;
		}
		
		return false;
		
	}
	
	

	//insert
	private void insert(Node parent, Node child) {
		
		//if child less than parent, child goes to left
		if(child.item.compareTo(parent.getItem()) < 0) {
			
			if(null == parent.getLeft()) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}
			//recursive to check the left or right child item
			else {
				insert(parent.getLeft(), child);
			}
		}
		else if(child.item.compareTo(parent.getItem()) > 0){
			if(null == parent.getRight()) {
				parent.setRight(child);
				child.setParent(parent);//setting parent ref back
				this.size++;
			}
			//recursive to check the left or right child item
			else {
				insert(parent.getRight(), child);
			}
		}
		
		/**
		 * If parent and child data both are equal --> check the logic that needs to be implemented.
		 */
		
	}
	
	
	private class Node {
		
		private Node left;
		private Node right;
		private Node parent;
		private X item;
		
		//Constructor
		public Node(X item) {
			this.left = null;
			this.right = null;
			this.parent = null;
			this.item = item;
		}

		public Node getLeft() {
			return left;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
				
		
	}
}
